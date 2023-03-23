public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";


    public static void main(String[] args) {
        // Представьте, что вы пишете класс Reder, который отвечает за вывод на экран текущего уровня жизней и усталости какого-то объекта.
        // (Подразумеваем, что вывод на экран - это просто печать в консоль)
        // У класса есть 1 метод, который принимает тип Object и делает следующее:
        // 1. Если object типа HasHealthPoint, то выводим его уровень жизни
        // 2. Если object типа Tiredness, то выводим его уровень усталости
        // При этом текст значения должен иметь цвет в соответствии с правилом:
        // BLACK(0, 24), RED(25, 50), GREEN(51-100)
        // 3. Создать несколько классов:
        // 3.1 Здание. Имеет только жизни.
        // 3.2 Персноаж. Имеет и жизни, и усталость

        Building building = new Building(100, 40);
        Hero Mars = new Hero(50, 40, 100, 60);
        Render render = new Render();
        // render.render(building);
        render.render(Mars);
        render.render(building);
    }

    static class Render {

        public void render(Object object) {

            if (object instanceof HasHealthPoint healthPoint) {
                System.out.println("хп:");
                int procentHealthPoint = healthPoint.getProcentHealthPoint();
                if (procentHealthPoint < 25) {
                    System.out.println(ANSI_BLACK + procentHealthPoint + ANSI_RESET);
                }
                else if(procentHealthPoint < 50 && procentHealthPoint > 24){
                    System.out.println(ANSI_RED + procentHealthPoint + ANSI_RESET);
                }
                else if(procentHealthPoint < 101 && procentHealthPoint > 50){
                    System.out.println(ANSI_GREEN + procentHealthPoint + ANSI_RESET);
                }
            }


            if (object instanceof Tiredness energyPoint) {
                System.out.println("Энергия: ");
                int procentEnergyPoint = energyPoint.getProcentEnergyPoint();
                if (procentEnergyPoint < 25) {
                    System.out.println(ANSI_BLACK + procentEnergyPoint + ANSI_RESET);
                }
                else if(procentEnergyPoint < 50 && procentEnergyPoint > 24){
                    System.out.println(ANSI_RED + procentEnergyPoint + ANSI_RESET);
                }
                else if(procentEnergyPoint < 101 && procentEnergyPoint > 50){
                    System.out.println(ANSI_GREEN + procentEnergyPoint + ANSI_RESET);
                }
            }      
        }
    }
        
    

    interface HasHealthPoint {

        int getMaxHealthPoint();

        int getCurrentHealthPoint();

        int getProcentHealthPoint();

    }

    interface Tiredness {

        // Максимальное значение уровеня бодрости объекта
        int getMaxEnergy();

        // Текущее значение уровеня бодрости объекта
        int getCurrentEnergy();

        int getProcentEnergyPoint();

    }

    static class Building implements HasHealthPoint {

        private final int maxHealthPoint;
        private int currentHealthPoint;
        private int procentHealthPoint;
        public Building(int maxHealthPoint, int currentHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = currentHealthPoint;
            this.procentHealthPoint = currentHealthPoint * 100 / maxHealthPoint;
        }

        @Override
        public int getMaxHealthPoint() {
            return maxHealthPoint;
        }

        @Override
        public int getCurrentHealthPoint() {
            return currentHealthPoint;
        }
        @Override
        public int getProcentHealthPoint() {
            return procentHealthPoint;
        }
        
    }

    static class Hero implements HasHealthPoint, Tiredness {

        private final int maxHealthPoint;
        private int currentHealthPoint;
        private final int maxEnergy;
        private int currentEnergy;
        private int procentHealthPoint;
        private int procentEnergyPoint;
        public Hero(int maxHealthPoint, int currentHealthPoint, int maxEnergy, int currentEnergy){
            this.maxHealthPoint = maxHealthPoint;
            this.currentEnergy = currentHealthPoint;
            this.maxEnergy = maxEnergy;
            this.currentEnergy = currentEnergy;
            this.procentHealthPoint = currentHealthPoint * 100 / maxHealthPoint;
            this.procentEnergyPoint = currentEnergy * 100/ maxEnergy;
        }

        @Override
        public int getMaxHealthPoint() {
            return maxHealthPoint;
        }

        @Override
        public int getProcentHealthPoint() {
            return procentHealthPoint;
        }

        @Override
        public int getMaxEnergy() {
            return maxEnergy;
        }

        @Override
        public int getCurrentHealthPoint() {
            return currentHealthPoint;
        }

        @Override
        public int getCurrentEnergy() {
            return currentEnergy;
        }

        @Override
        public int getProcentEnergyPoint() {
            return procentEnergyPoint;
        }
    }

}

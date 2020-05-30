package hw6.animals;

public class Cat extends Animal {
    int ageOldYangForAnimal = 4;
    int runDistanceForOldAnimal = 300;
    int runDistanceForYangAnimal = 500;
    int swimDistanceForOldAnimal = 0;
    int swimDistanceForYangAnimal = 0;
    double jumpDistanceForOldAnimal = 1;
    double jumpDistanceForYangAnimal = 2;

    public static int counter = 0;

    public Cat(String name, int age) {
        super(name, age);
        counter++;
    }

    public void checkRunDistance(int h, int runDistanceForYangAnimal, int runDistanceForOldAnimal, int ageOldYangForAnimal) {
        super.checkRunDistance(h, runDistanceForYangAnimal, runDistanceForOldAnimal, ageOldYangForAnimal);
    }

    public void checkRunDistance(int h) {
        this.checkRunDistance(h, runDistanceForYangAnimal, runDistanceForOldAnimal, ageOldYangForAnimal);
    }

    @Override
    public void checkSwimDistance(int h, int swimDistanceForYangAnimal, int swimDistanceForOldAnimal, int ageOldYangForAnimal) {
        System.out.println("Боюсь " + name + " поплывет не в даль, а в глубь.");
    }

    public void checkSwimDistance(int h) {
        this.checkSwimDistance(h, swimDistanceForYangAnimal, swimDistanceForOldAnimal, ageOldYangForAnimal);
    }

    public void checkJumpLength(double h, double jumpDistanceForYangAnimal, double jumpDistanceForOldAnimal, int ageOldYangForAnimal) {
        super.checkJumpLength(h, jumpDistanceForYangAnimal, jumpDistanceForOldAnimal, ageOldYangForAnimal);
    }

    public void checkJumpLength(double h) {
        this.checkJumpLength(h, jumpDistanceForYangAnimal, jumpDistanceForOldAnimal, ageOldYangForAnimal);
    }

//    @Override
//    public void checkRunDistance(int h) {
//        if (h > runDistanceForYangAnimal) {
//            System.out.println("Ни один кошак не пробежит " + h + " метров.");
//        } else if (age < ageOldYangForAnimal && h < runDistanceForYangAnimal) {
//            System.out.println(name + " легко пробежит " + h + " метров.");
//        } else if (age >= ageOldYangForAnimal && h > runDistanceForOldAnimal) {
//            System.out.println(name + " слишком стар для забега в " + h + " метров.");
//        }
//    }
//
//    @Override
//    public void checkSwimDistance(int h) {
//        System.out.println("Боюсь " + name + " поплывет не в даль, а в глубь.");
//    }
//
//    @Override
//    public void checkJumpLength(double h) {
//        if (h > jumpDistanceForYangAnimal) {
//            System.out.println("Ни один кошак не прыгнет на " + h + " метров.");
//        } else if (age < ageOldYangForAnimal && h < jumpDistanceForYangAnimal) {
//            System.out.println(name + " легко прыгнет на " + h + " метров.");
//        } else if (age >= ageOldYangForAnimal && h > jumpDistanceForOldAnimal) {
//            System.out.println(name + " слишком стар для прыжка на " + h + " метров.");
//        }
//    }
}

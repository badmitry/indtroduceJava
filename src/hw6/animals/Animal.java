package hw6.animals;

abstract class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void checkRunDistance(int h, int runDistanceForYangAnimal, int runDistanceForOldAnimal, int ageOldYangForAnimal) {
        if (h > runDistanceForYangAnimal) {
            System.out.println(name + " не пробежит " + h + " метров.");
        } else if (age < ageOldYangForAnimal && h < runDistanceForYangAnimal) {
            System.out.println(name + " легко пробежит " + h + " метров.");
        } else if (age >= ageOldYangForAnimal && h > runDistanceForOldAnimal) {
            System.out.println(name + " слишком стар для забега в " + h + " метров.");
        }
    }

    void checkSwimDistance(int h, int swimDistanceForYangAnimal, int swimDistanceForOldAnimal, int ageOldYangForAnimal) {
        if (h > swimDistanceForYangAnimal) {
            System.out.println(name + " не проплывет " + h + " метров.");
        } else if (age < ageOldYangForAnimal && h < swimDistanceForYangAnimal) {
            System.out.println(name + " легко проплывет " + h + " метров.");
        } else if (age >= ageOldYangForAnimal && h > swimDistanceForOldAnimal) {
            System.out.println(name + " слишком стар для заплыва в " + h + " метров.");
        }
    }


    void checkJumpLength(double h, double jumpDistanceForYangAnimal, double jumpDistanceForOldAnimal, int ageOldYangForAnimal) {
        if (h > jumpDistanceForYangAnimal) {
            System.out.println(name + "  не прыгнет на " + h + " метров.");
        } else if (age < ageOldYangForAnimal && h < jumpDistanceForYangAnimal) {
            System.out.println(name + " легко прыгнет на " + h + " метров.");
        } else if (age >= ageOldYangForAnimal && h > jumpDistanceForOldAnimal) {
            System.out.println(name + " слишком стар для прыжка на " + h + " метров.");
        }
    }

}

package hw6.animals;

public class Dog extends Animal {
    public static int counter = 0;
    int ageOldYangForAnimal = 4;
    int runDistanceForOldAnimal = 500;
    int runDistanceForYangAnimal = 1000;
    int swimDistanceForOldAnimal = 10;
    int swimDistanceForYangAnimal = 20;
    double jumpDistanceForOldAnimal = 0.5;
    double jumpDistanceForYangAnimal = 1;

    public Dog(String name, int age) {
        super(name, age);
        counter++;
    }

    public void checkRunDistance(int h, int runDistanceForYangAnimal, int runDistanceForOldAnimal, int ageOldYangForAnimal) {
        super.checkRunDistance(h, runDistanceForYangAnimal, runDistanceForOldAnimal, ageOldYangForAnimal);
    }

    public void checkRunDistance(int h) {
        this.checkRunDistance(h, runDistanceForYangAnimal, runDistanceForOldAnimal, ageOldYangForAnimal);
    }

    public void checkSwimDistance(int h, int swimDistanceForYangAnimal, int swimDistanceForOldAnimal, int ageOldYangForAnimal) {
        super.checkSwimDistance(h, swimDistanceForYangAnimal, swimDistanceForOldAnimal, ageOldYangForAnimal);
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

}

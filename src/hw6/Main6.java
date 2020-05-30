package hw6;

import hw6.animals.Cat;
import hw6.animals.Dog;

public class Main6 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Снежок", 6);
        Cat cat2 = new Cat("Пушок", 2);
        Dog dog1 = new Dog("Дружок", 7);
        Dog dog2 = new Dog("Шарик", 2);
        System.out.printf("Всего мы завели %d кошек и %d собак.%n", Cat.counter, Dog.counter);
        System.out.println();


        cat1.checkRunDistance(400);
        cat2.checkRunDistance(400);
        cat1.checkJumpLength(1.5);
        cat2.checkJumpLength(1.5);
        cat1.checkSwimDistance(10);
        System.out.println();
        dog1.checkRunDistance(700);
        dog2.checkRunDistance(700);
        dog1.checkRunDistance(1100);
        dog2.checkJumpLength(0.7);
        dog1.checkJumpLength(0.7);
        dog2.checkSwimDistance(15);
        dog1.checkSwimDistance(15);
    }
}

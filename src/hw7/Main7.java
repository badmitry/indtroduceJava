package hw7;

import java.util.Arrays;

public class Main7 {
    public static void main(String[] args) {
        // создаем котов
        hw7.Cat[] cats = new hw7.Cat[7];
        cats[0] = new hw7.Cat("cat1", 23);
        cats[1] = new hw7.Cat("cat2", 22);
        cats[2] = new hw7.Cat("cat3", 0);
        cats[3] = new hw7.Cat("cat4", 19);
        cats[4] = new hw7.Cat("cat5", 17);
        cats[5] = new hw7.Cat("cat6", 22);
        cats[6] = new hw7.Cat("cat7", 27);


        //подаем котам тарелку с произвольным количеством еды и кормим их
        feedCats(110, cats);
        System.out.println();
        //подаем блюдо повторно
        feedCats(40, cats);


    }
    static void feedCats(int food, Cat[] cats){
        //создаем тарелку с едой
        Plate plate = new Plate(food);
        //сортируем массив чтобы к тарелке бежали сначала самые голодные коты
        Arrays.sort(cats, new SortBySatiety());
        //коты набрасываются на еду
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
        }

    }
}

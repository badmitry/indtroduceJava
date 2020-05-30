package hw7;

public class Cat {
    String name;
    int satiety;

    public Cat(String name, int satiety) {
        this.name = name;
        this.satiety = satiety;
    }

    public int getSatiety() {
        return satiety;
    }

    public void eat(Plate plate) {
        if (satiety == 0) {
            System.out.println("Кот " + name + " сыто урчит. Жрать он не хочет.");
        } else {
            if (plate.getFood() == 0) {
                System.out.println("Еда кончилась, кот " + name + " остался голоден.");
            } else if (plate.getFood() < satiety) {
                System.out.println("Еды осталось мало и кот " + name + " брезгует есть эти остатки.");
            } else {
                plate.setFood(plate.getFood() - satiety);
                System.out.println("Кот " + name + " наелся и доволен.");
                satiety = 0;
            }
        }

    }

}

package hw5OOP;

public class Staffs {
    public static final String ORGANIZATION = "Horns and Hooves";
    public String name;
    public String position;
    public String eMail;
    public String poneNumber;
    public int sizePai;
    public int age;


    public Staffs() {
//        this.name = "неизвестный";
//        this.position = "сотрудник";
//        this.eMail = "ящик";
//        this.poneNumber = "смотри в справочнике";
//        this.sizePai = 0;
//        this.age = 18;
        this("не задан", "новый сотрудник", "еще не выделен", "отсутсвует", 0, 18);
    }

    public Staffs(String name, String position, String eMail, String poneNumber, int sizePai, int age) {
        this.name = name;
        this.position = position;
        this.eMail = eMail;
        this.poneNumber = poneNumber;
        this.sizePai = sizePai;
        this.age = age;
    }


    public void information() {
        System.out.printf("Организация: %s%nИмя сотрудника: %s.%nДолжность сотрудника: %s.%nЭлектронная почта сотрудника: %s.%nТелефон сотрудника: %s%n" +
                "Зарплата сотрудника: %d.%nВозраст сотрудника: %d%n", ORGANIZATION, name, position, eMail, poneNumber, sizePai, age);
    }
}

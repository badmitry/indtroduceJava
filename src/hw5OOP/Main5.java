package hw5OOP;

public class Main5 {

    public static void main(String[] args) {
//	    Staffs staff1 = new Staffs("asdf", "sdff", "dsfdsf", "dsdf", 11, 11);
//	    staff1.information();
//        Staffs staff2 = new Staffs();
//        staff2.information();
        Staffs[] arrStaffs = new Staffs[5];

        arrStaffs[0] = new Staffs("Вася Иванов", "ГенДир", "vasia@evil.com", "666+1", 1000000, 66);
        arrStaffs[1] = new Staffs("Петя Иванов", "Зам ГенДира", "petya@evil.com", "666+2", 1000000, 60);
        arrStaffs[2] = new Staffs("Коля Иванов", "Советник ГенДира", "kolia@evil.com", "666+3", 1000000, 32);
        arrStaffs[3] = new Staffs("Дима Иванов", "Зам Советника ГенДира", "dima@evil.com", "666+4", 1000000, 40);
        arrStaffs[4] = new Staffs("Лидия Петровна", "Уборщица", "clian@evil.com", "666+5", 100, 45);
        System.out.println("ООО \"" + arrStaffs[0].ORGANIZATION + "\":");
        System.out.println();
        for (int i = 0; i < 5; i++) {
            if (arrStaffs[i].age > 40) {
                arrStaffs[i].information();
                System.out.println();
            }

        }
    }


}

package hw1;

public class Main1 {

    public static void main(String[] args) {
        byte byteNumber = 127;
        short shortNumber = 1111;
        int intNumber = 111111;
        long longNumber = 11111111111111L;

        float floatNumber = 1.1f;
        double doubelNumber = 1.1;

        char charSimbol = 1111;

        boolean booleanX = false;
        System.out.printf("%10.2f%n", mathMethod(1, 2, 3, 4));
        System.out.printf("%1$10b%n", numberTrue(10, 9));
        checkPositiveNegative(-5);
        System.out.printf("%10b%n", checkNumberTrueNegative(-1));
        helloName("BaDmitry");
        checkYear(400);
        checkYear(200);
        checkYear(4010);
        checkYear(4004);
        int binNumber = 3;
        String binString = Integer.toBinaryString(binNumber);
        System.out.printf("%1$s", binString);
    }


    static double mathMethod (double a, double b, double c, double d){
        return a * (b + (c / d));
    }

    static boolean numberTrue (int a, int b){
        return (10 < (a + b) && (a+ b) < 20);
    }

    static void checkPositiveNegative (int a){
        if (a >= 0){
            System.out.printf("%1$10d is a positive number%n", a);
        } else {
            System.out.printf("%1$10d is a negative number%n", a);
        }
    }

    static boolean checkNumberTrueNegative (int a){
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    static void helloName (String a) {
        System.out.printf("Привет, %.10s, nise to meet you!%n", a);
    }

    static void checkYear (int a) {
        if (a % 400 == 0) {
            System.out.printf("%4d год - высокосный.%n", a);
        } else if (a % 100 == 0) {
            System.out.printf("%1$4d год%1$d - не высокосный.%n", a);
        } else if (a % 4 == 0) {
            System.out.printf("%4d год - высокосный.%n", a);
        } else {
            System.out.printf("%4d год - не высокосный.%n", a);
        }
    }

}

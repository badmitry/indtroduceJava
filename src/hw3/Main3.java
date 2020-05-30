package hw3;

import java.util.Random;
import java.util.Scanner;

public class Main3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // задание угадать число
        repiatGame();
        // угадать слово
        guesWord();
    }

    public static void guesNumber (){

        Random number = new Random();
        int randomNumber = number.nextInt(10);
        System.out.println("Привет, угадайте число от 0 до 9:");
        for (int i = 0; i < 3; i++) {
            System.out.printf("У Вас осталось %d попытки", 3-i);
            int userNumber = sc.nextInt();
            if (userNumber < randomNumber) {
                System.out.println("Ваше число слишком маленькое");
            } else if (userNumber > randomNumber) {
                System.out.println("Ваше число слишком большое");
            } else {
                System.out.println("Вы победили!!!");
                break;
            }
        }
        System.out.println("Игра закончена");


    }

    public static void repiatGame() {
        int userAnswer = 1;
        do {
            if (userAnswer == 1){
                guesNumber();
            } else {
                break;
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            userAnswer = sc.nextInt();
        }while (true);
    }

    static void guesWord() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Угадайте слово");
        Random number = new Random();
        String questionWord = words[number.nextInt(words.length)];
        int lengthWord;

        // экранируем /n
        String userAnswer = sc.nextLine();

        do {
            System.out.println("введите слово:");
            userAnswer = sc.nextLine();
            if (userAnswer.equals(questionWord)){
                System.out.println("Вы угадали!!!");
                break;
            }
            if (userAnswer.length() > questionWord.length()){
                lengthWord = questionWord.length();
            }else{
                lengthWord = userAnswer.length();
            }

            for (int i = 0; i < lengthWord; i++) {
                if (userAnswer.charAt(i) == questionWord.charAt(i)){
                    System.out.printf("%s", userAnswer.charAt(i));
                } else {
                    System.out.printf("#");
                }
            }
            for (int i = lengthWord; i < 15 ; i++) {
                System.out.printf("#");
            }
            System.out.println();


        } while (true);


    }
}

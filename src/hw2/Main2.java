package hw2;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        //task 1
        int [] arrBin = new int[] {1, 0, 0, 1};
        changeNumbers(arrBin);
        printArr(arrBin);

        //task 2
        int [] arrLong8 = new int[8];
        for (int i = 0; i < arrLong8.length; i++) {
            arrLong8[i] = i * 3;
        }
        printArr(arrLong8);

        //task 3
        int [] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *=2;
            }
        }
        printArr(arr3);
        System.out.println();



        //task 4
        int [][] arrSquare = new int [5][5];
        for (int i = 0; i < arrSquare.length ; i++) {
            for (int j = 0; j < arrSquare[i].length ; j++) {
                if (i == j || i + j == arrSquare.length - 1) {
                    arrSquare[i][j] = 1;
                }
                System.out.printf("%2d", arrSquare[i][j]);
            }
            System.out.println();
        }

        //task 5
        int [] arr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int maxNumber = arr5[0];
        int minNumber = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if (maxNumber < arr5[i]){
                maxNumber = arr5[i];
            }
            if (minNumber > arr5[i]){
                minNumber = arr5[i];
            }
        }
        System.out.printf("Нам дан массив %s.%n", Arrays.toString(arr5));
        System.out.printf("Максимальное число массива равно %d, а минимальное число массива равно %d.%nМожно ли разделить данный массив " +
                "на 2 равные части?%n", maxNumber, minNumber);

        //task 6
        System.out.println(checkBalanse(arr5));
        System.out.printf("А новый массив - %s?%n", Arrays.toString(arr3));
        System.out.println(checkBalanse(arr3));

        //task 7
        System.out.printf("Сдвинем массив %s на 2 знака вперед:%n", Arrays.toString(arr3));
        arrMove(arr3, -2);
        printArr(arr3);
        System.out.println("Сдвинем новый массив на 3 знака назад:");
        arrMove(arr3, 3);
        printArr(arr3);

    }

    public static void changeNumbers(int arr[]){
        for (int i = 0; i < arr.length; i++){
            if (arr [i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
    }

    public static void printArr(int arr[]){
        for (int i = 0; arr.length > i; i++){
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    public static boolean checkBalanse(int arr[]){
        int summArr = 0;
        int summArr2 = 0;
        for (int i = 0; i < arr.length; i++) {
            summArr+=arr[i];
        }
        for (int i = 0; i < arr.length - 1 ; i++) {
            summArr2+=arr[i];
            if (summArr2 == summArr/2 && summArr%2 == 0){
                return true;
            }
        }
        return false;
    }

    //task 7****
    public static void arrMove (int arr[], int n) {
        int x;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                x = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = x;
            }
        }else {
            for (int i = 0; i > n; i--) {
                x = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = x;
            }
        }
    }


}

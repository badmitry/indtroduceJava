package hw4;

import java.util.Random;
import java.util.Scanner;

public class Main4 {

    static final char CHAR_X = 'X';
    static final char CHAR_O = 'O';
    static final char CHAR_IS_EMPTY = '.';
    public static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Введите размер таблицы (минимум 3, максимум 99):");
        int size = scanner.nextInt();
        if (size < 3 || size > 99) {
            size = 3;
        }
        System.out.println("Введите длину минимальную длину линии для выйгрыша не более размера таблицы (минимум 3):");
        int lengthLine = scanner.nextInt();
        if (lengthLine < 3 || lengthLine > size) {
            lengthLine = 3;
        }
        char playField[][] = new char[size][size];

        buildField(size, playField);

        printField(size, playField);

        int counter = 0;
        while (true) {
            playerShot(size, playField);
            printField(size, playField);
            if (checkWin(size, lengthLine, playField, CHAR_X)) {
                System.out.println("Вы победили.");
                break;
            }
            counter++;
            if (counter == size * size) {
                System.out.println("Ничья.");
                break;
            }

            aiShot(size, lengthLine, playField, counter);
            printField(size, playField);
            if (checkWin(size, lengthLine, playField, CHAR_O)) {
                System.out.println("Вы проиграли.");
                break;
            }
            counter++;
            if (counter == size * size) {
                System.out.println("Ничья.");
                break;
            }
        }


    }

    public static void buildField(int size, char arr[][]) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = CHAR_IS_EMPTY;
            }
        }
    }

    public static void printField(int size, char arr[][]) {
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size + 1; j++) {
                if (i == 0) {
                    System.out.printf("%2d ", j);
                } else if (j == 0) {
                    System.out.printf("%2d ", i);
                } else {
                    System.out.printf("%2s ", arr[i - 1][j - 1]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void playerShot(int size, char arr[][]) {
        while (true) {
            System.out.println("Введите координаты X и Y:");
            int y = scanner.nextInt() - 1;
            int x = scanner.nextInt() - 1;
            if (x >= 0 && y >= 0 && x < size && y < size && arr[x][y] == CHAR_IS_EMPTY) {
                arr[x][y] = CHAR_X;
                break;
            }
            System.out.println("Эта клетка занята, попробуйте еще раз.");
        }

    }

    public static void randomAiShot(int size, char arr[][]) {
        while (true) {
            int y = random.nextInt(size);
            int x = random.nextInt(size);
            if (arr[x][y] == CHAR_IS_EMPTY) {
                arr[x][y] = CHAR_O;
                System.out.printf("Он случайно ходит в точку: %d %d", x + 1, y + 1);
                System.out.println();
                break;
            }
        }

    }

    public static void aiShot(int size, int lengthLine, char arr[][], int checkFierstMove) {
        if (checkFierstMove <= 1) {
            System.out.println("AI делает первый ход");
            randomAiShot(size, arr);
            return;
        }
        int counter = 0;
        int optimalI = 0;
        int optimalJ = 0;
        int countOptimalMove = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == CHAR_IS_EMPTY) {
                    arr[i][j] = CHAR_O;
                    if (checkWin(size, lengthLine, arr, CHAR_O)) {
                        System.out.printf("AI делает победный ход в точку: %d %d", j + 1, i + 1);
                        System.out.println();
                        return;
                    }
                    arr[i][j] = CHAR_IS_EMPTY;

                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == CHAR_IS_EMPTY) {
                    arr[i][j] = CHAR_X;
                    if (checkWin(size, lengthLine, arr, CHAR_X)) {
                        arr[i][j] = CHAR_O;
                        System.out.printf("AI рушит планы игрока на победу ходом в точку: %d %d", j + 1, i + 1);
                        System.out.println();
                        return;
                    }
                    arr[i][j] = CHAR_O;
                    if (countOptimalMove == 0) {
                        countOptimalMove = checkWinInFuture(size, lengthLine, arr, counter++);
                        if (countOptimalMove != 0) {
                            optimalI = i;
                            optimalJ = j;
                        }

                    } else {
                        int x = checkWinInFuture(size, lengthLine, arr, counter++);
                        if (x != 0 && countOptimalMove > x) {
                            countOptimalMove = x;
                            optimalI = i;
                            optimalJ = j;
                        }
                    }
                    arr[i][j] = CHAR_IS_EMPTY;
                }
            }
        }
        if(countOptimalMove !=0){
        arr[optimalI][optimalJ] = CHAR_O;
        System.out.printf("AI рассчетливо пошол в точку: %d %d", optimalJ + 1, optimalI + 1);
        System.out.println();
    } else {
        System.out.println("AI отчаялся победить.");
        randomAiShot(size, arr);
        return;
    }

}

    public static int checkWinInFuture(int size, int lengthLine, char arr[][], int counter) {
        int counterMove = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int counterMoveInsert = 0;
                if (arr[i][j] == CHAR_IS_EMPTY) {
                    arr[i][j] = CHAR_O;
                    if (checkWin(size, lengthLine, arr, CHAR_O)) {
                        counterMoveInsert++;
                        arr[i][j] = CHAR_IS_EMPTY;
                        return counterMoveInsert;
                    } else if (counter < lengthLine * lengthLine) {
                        counterMoveInsert = checkWinInFuture(size, lengthLine, arr, counter++);
                        if (counterMoveInsert != 0) {
                            counterMoveInsert++;
                        }
                    }
                    arr[i][j] = CHAR_IS_EMPTY;
                    if (counterMove == 0 && counterMoveInsert != 0) {
                        counterMove = counterMoveInsert;
                    } else if (counterMoveInsert != 0 && counterMoveInsert < counterMove) {
                        counterMove = counterMoveInsert;
                    }
                }

            }
        }
        return counterMove;
    }

    public static boolean checkWin(int size, int lengthLine, char arr[][], char playerChar) {
        int counterCheck = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[i][j] == playerChar) {
                    counterCheck++;

                    for (int k = 1; k < lengthLine; k++) {
                        if (i + k > size - 1) {
                            counterCheck = 1;
                            break;
                        } else if (arr[i + k][j] == playerChar) {
                            counterCheck++;
                        } else {
                            counterCheck = 1;
                            break;
                        }
                    }
                    if (counterCheck == lengthLine) {
                        return true;
                    }

                    for (int k = 1; k < lengthLine; k++) {
                        if (j + k > size - 1) {
                            counterCheck = 1;
                            break;
                        } else if (arr[i][j + k] == playerChar) {
                            counterCheck++;
                        } else {
                            counterCheck = 1;
                            break;
                        }
                    }
                    if (counterCheck == lengthLine) {
                        return true;
                    }

                    for (int k = 1; k < lengthLine; k++) {
                        if (j + k > size - 1 || i - k < 0) {
                            counterCheck = 1;
                            break;
                        } else if (arr[i - k][j + k] == playerChar) {
                            counterCheck++;
                        } else {
                            counterCheck = 1;
                            break;
                        }
                    }
                    if (counterCheck == lengthLine) {
                        return true;
                    }

                    for (int k = 1; k < lengthLine; k++) {
                        if (j + k > size - 1 || i - k < 0) {
                            counterCheck = 1;
                            break;
                        } else if (arr[i - k][j + k] == playerChar) {
                            counterCheck++;
                        } else {
                            counterCheck = 1;
                            break;
                        }
                    }
                    if (counterCheck == lengthLine) {
                        return true;
                    }

                    for (int k = 1; k < lengthLine; k++) {
                        if (j + k > size - 1 || i + k > size - 1) {
                            counterCheck = 1;
                            break;
                        } else if (arr[i + k][j + k] == playerChar) {
                            counterCheck++;
                        } else {
                            counterCheck = 1;
                            break;
                        }
                    }
                    if (counterCheck == lengthLine) {
                        return true;
                    }
                    counterCheck = 0;
                }
            }

        }
        return false;
    }


}
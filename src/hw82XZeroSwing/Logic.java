package hw82XZeroSwing;

import java.sql.SQLOutput;
import java.util.Random;

public class Logic {

    static final char CHAR_X = 'X';
    static final char CHAR_O = 'O';
    static final char CHAR_IS_EMPTY = '.';
    static final char winCharX = 'x';
    static final char winCharO = 'o';
    private static Random random = new Random();
    static boolean gameFinished = false;
    static int size;
    static int lengthLine;
    public static char playField[][];
    static int counterMove;

    public static void buildField() {
        playField = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                playField[i][j] = CHAR_IS_EMPTY;
            }
        }
    }

    public static void printField() {
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < size + 1; j++) {
                if (i == 0) {
                    System.out.printf("%2d ", j);
                } else if (j == 0) {
                    System.out.printf("%2d ", i);
                } else {
                    System.out.printf("%2s ", playField[j - 1][i - 1]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void playerShot(char simbol, int cellX, int cellY) {
        while (true) {
            if (cellX >= 0 && cellY >= 0 && cellX < size && cellY < size && playField[cellX][cellY] == CHAR_IS_EMPTY) {
                playField[cellX][cellY] = simbol;
                break;
            }
        }
        if (checkWinFinal(simbol)) {
            gameFinished = true;
            Window.jlMessage.setText("win " + simbol);
        }

        counterMove++;
        if (counterMove == size * size) {
            gameFinished = true;
            Window.jlMessage.setText("Draw");
        }

    }

    public static void randomAiShot() {
        while (true) {
            int y = random.nextInt(size);
            int x = random.nextInt(size);
            if (playField[x][y] == CHAR_IS_EMPTY) {
                playField[x][y] = CHAR_O;
                break;
            }
        }

    }

    public static void aiShot() {
        int counter = 0;
        int optimalI = 0;
        int optimalJ = 0;
        int countOptimalMove = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playField[i][j] == CHAR_IS_EMPTY) {
                    playField[i][j] = CHAR_O;
                    if (checkWinFinal(CHAR_O)) {
                        gameFinished = true;
                        Window.jlMessage.setText("win Ai");
                        return;
                    }
                    playField[i][j] = CHAR_X;
                    if (checkWin(CHAR_X)) {
                        playField[i][j] = CHAR_O;
                        return;
                    }
                    playField[i][j] = CHAR_O;
                    if (countOptimalMove == 0) {
                        countOptimalMove = checkWinInFuture(counter++);
                        if (countOptimalMove != 0) {
                            optimalI = i;
                            optimalJ = j;
                        }

                    } else {
                        int x = checkWinInFuture(counter++);
                        if (x != 0 && countOptimalMove > x) {
                            countOptimalMove = x;
                            optimalI = i;
                            optimalJ = j;
                        }
                    }
                    playField[i][j] = CHAR_IS_EMPTY;
                }
            }
        }
        if (countOptimalMove != 0) {
            playField[optimalI][optimalJ] = CHAR_O;
            return;
        } else {
            randomAiShot();
        }

        counterMove++;
        if (counterMove == size * size) {
            gameFinished = true;
            Window.jlMessage.setText("Draw");
        }

    }

    public static int checkWinInFuture(int counter) {
        int counterMove = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int counterMoveInsert = 0;
                if (playField[i][j] == CHAR_IS_EMPTY) {
                    playField[i][j] = CHAR_O;
                    if (checkWin(CHAR_O)) {
                        counterMoveInsert++;
                        playField[i][j] = CHAR_IS_EMPTY;
                        return counterMoveInsert;
                    } else if (counter < lengthLine * lengthLine) {
                        counterMoveInsert = checkWinInFuture(counter++);
                        if (counterMoveInsert != 0) {
                            counterMoveInsert++;
                        }
                    }
                    playField[i][j] = CHAR_IS_EMPTY;
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

    public static boolean checkWinFinal(char playerChar) {
        char winChar;
        if (playerChar == 'X') {
            winChar = winCharX;
        } else {
            winChar = winCharO;
        }
        int counterCheck = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playField[i][j] == playerChar) {
                    counterCheck++;
                    playField[i][j] = winChar;

                    for (int k = 1; k < lengthLine; k++) {
                        if (i + k > size - 1) {
                            counterCheck = 1;
                            break;
                        } else if (playField[i + k][j] == playerChar) {
                            counterCheck++;
                            playField[i + k][j] = winChar;
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
                        } else if (playField[i][j + k] == playerChar) {
                            counterCheck++;
                            playField[i][j + k] = winChar;
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
                        } else if (playField[i - k][j + k] == playerChar) {
                            counterCheck++;
                            playField[i - k][j + k] = winChar;
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
                        } else if (playField[i - k][j + k] == playerChar) {
                            counterCheck++;
                            playField[i - k][j + k] = winChar;
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
                        } else if (playField[i + k][j + k] == playerChar) {
                            counterCheck++;
                            playField[i + k][j + k] = winChar;
                        } else {
                            counterCheck = 1;
                            break;
                        }
                    }
                    if (counterCheck == lengthLine) {
                        return true;
                    }

                    counterCheck = 0;
                    for (int k = 0; k < size; k++) {
                        for (int l = 0; l < size; l++) {
                            if (playField[k][l] == winChar) {
                                playField[k][l] = playerChar;
                            }

                        }

                    }
                }
            }

        }
        return false;
    }

    public static boolean checkWin(char playerChar) {
        int counterCheck = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playField[i][j] == playerChar) {
                    counterCheck++;

                    for (int k = 1; k < lengthLine; k++) {
                        if (i + k > size - 1) {
                            counterCheck = 1;
                            break;
                        } else if (playField[i + k][j] == playerChar) {
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
                        } else if (playField[i][j + k] == playerChar) {
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
                        } else if (playField[i - k][j + k] == playerChar) {
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
                        } else if (playField[i - k][j + k] == playerChar) {
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
                        } else if (playField[i + k][j + k] == playerChar) {
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

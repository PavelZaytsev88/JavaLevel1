package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TikTakToe {
    public static final String HEADER_FIRST_SYMBOL = "♥";
    public static final String SPACE_MAP_SYMBOL = " ";
    private static int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;

    private static final char DOT_EMPTY = '.';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';

    private static final char[][] MAP = new char[SIZE][SIZE];

    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();
    private static int turnsCount = 0;

    public static void main(String[] args) {
        turnGame();

    }

    private static void turnGame() {
        initMap();
        printMAP();
        playGame();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;

            }

        }
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMAP();
            if (isCheckEnd(DOT_HUMAN)) {
                break;
            }

            aiTurt();
            printMAP();
            if (isCheckEnd(DOT_AI)) {
                break;
            }
        }
    }


    private static void humanTurn() {
        System.out.println("\nХОД ЧЕЛОВЕКА!");
        int rowNumber;
        int columnNumber;

        while (true) {
            System.out.print("Введите координату строки: ");
            rowNumber = in.nextInt() - 1;
            System.out.print("Введите координату столбца: ");
            columnNumber = in.nextInt() - 1;

            if (isCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.printf("ОШИБКА! Ячейка с координатами %s:%s уже используется.\n ", rowNumber + 1, columnNumber + 1);
        }
        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static void aiTurt() {
        System.out.println("\nХОД КОМПЬЮТЕРА!");
        int rowNumber;
        int columnNumber;

        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, columnNumber));


        MAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;

    }

    private static void printMAP() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            ptintMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP_SYMBOL);
            }
            System.out.println();
        }
    }

    private static void ptintMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP_SYMBOL);
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP_SYMBOL);
        for (int i = 0; i < SIZE; i++) {
            ptintMapNumber(i);
        }
        System.out.println();
    }

    private static boolean isCheckEnd(char symbol) {
        if (CheckWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Ты победил, кожанный мешок с костями!");
            } else {
                System.out.println("Восстание машин близко");
            }
            return true;

        }

        if (checkDraw()) {
            System.out.println("НИЧЬЯ!");
            return true;
        }

        return false;
    }

    private static boolean checkDraw() {
        return turnsCount >= SIZE * SIZE;
    }

    private static boolean CheckWin(char symbol) {
        int hor, ver;
        int diagMain, diagReverse;
        for (int i = 0; i < SIZE; i++) {
            hor = 0;
            ver = 0;
            for (int j = 0; j < SIZE; j++) {
                if (MAP[i][j] == symbol) {                          // проверяем горизонтальные линии на возможную победу
                    hor++;
                } else if (MAP[i][j] != symbol && hor < DOTS_TO_WIN) {
                    hor = 0;
                }
                if (MAP[j][i] == symbol) {                          // проверяем вертикальные линии на возможную победу
                    ver++;
                } else if (MAP[j][i] != symbol && ver < DOTS_TO_WIN) {
                    ver = 0;
                }
            }
            if (hor >= DOTS_TO_WIN || ver >= DOTS_TO_WIN) {
                System.out.println("По горизонтали или вертикали " + hor + " " + ver);
                return true;
            }
        }

        for (int j = 0; j < SIZE; j++) {
            diagMain = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = j + i;
                if (k < SIZE) {
                    if (MAP[i][k] == symbol) {                      // проверяем главную диагональ от центральной оси вправо на возможную победу
                        diagMain++;
                    } else if (MAP[i][k] != symbol && diagMain < DOTS_TO_WIN) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= DOTS_TO_WIN) {
                    System.out.println("По главной диагонали от центральной оси вправо " + diagMain);
                    return true;
                }
            }
        }
        for (int j = 1; j < SIZE; j++) {
            diagMain = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = j + i;
                if (k < SIZE) {
                    if (MAP[k][i] == symbol) {                      // проверяем главную диагональ от центральной оси вниз на возможную победу
                        diagMain++;
                    } else if (MAP[k][i] != symbol && diagMain < DOTS_TO_WIN) {
                        diagMain = 0;
                    }
                }
                if (diagMain >= DOTS_TO_WIN) {
                    System.out.println("По главной диагонали от центральной оси вниз " + diagMain);
                    return true;
                }
            }
        }
        for (int j = 0; j < SIZE; j++) {
            diagReverse = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = (SIZE - 1) - i;
                int l = j + i;
                if (k >= 0 && l < SIZE) {
                    if (MAP[l][k] == symbol) {                     // проверяем побочную диагональ от центральной оси вниз на возможную победу
                        diagReverse++;
                    } else if (MAP[l][k] != symbol && diagReverse < DOTS_TO_WIN) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= DOTS_TO_WIN) {
                    System.out.println("По побочной диагонали от центральной оси вниз " + diagReverse);
                    return true;
                }
            }
        }
        for (int j = 1; j < SIZE; j++) {
            diagReverse = 0;
            for (int i = 0; i < SIZE; i++) {
                int k = (SIZE - 1) - j - i;
                if (k >= 0) {
                    if (MAP[i][k] == symbol) {     // проверяем побочную диагональ от центральной оси влево на возможную победу
                        diagReverse++;
                    } else if (MAP[i][k] != symbol && diagReverse < DOTS_TO_WIN) {
                        diagReverse = 0;
                    }
                }
                if (diagReverse >= DOTS_TO_WIN) {
                    System.out.println("По побочной диагонали от центральной оси влево " + diagReverse);
                    return true;
                }
            }
        }
        return false;
    }


}

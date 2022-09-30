package Lesson1;

import java.util.concurrent.ThreadLocalRandom;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        int varA = ThreadLocalRandom.current().nextInt(-10, 10);
        System.out.println(varA);
        int varB = ThreadLocalRandom.current().nextInt(-10, 10);
        System.out.println(varB);
        int result = varA + varB;
        if (result >= 0) {
            System.out.println("Сумма положительная");
        } else if (result < 0) {
            System.out.println("Сумма отрицательная");

        }

    }

    private static void printColor() {
        int value = ThreadLocalRandom.current().nextInt(-100, 200);
        System.out.println(value);
        if (value <= 0) {
            System.out.println("Red");
        } else if (value > 0 && value <= 100) {
            System.out.println("Yellow");

        } else if (value > 100) {
            System.out.println("Green");

        }
    }

    private static void compareNumbers() {
        int varA = ThreadLocalRandom.current().nextInt(-10, 10);
        System.out.println(varA);
        int varB = ThreadLocalRandom.current().nextInt(-10, 10);
        System.out.println(varB);
        if (varA >= varB) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }

    }
}
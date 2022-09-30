package Lesson2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println(within10and20(5, 8));
        PositiveOrNegative(-9);
        System.out.println(TrueOrFalse(8));
        StringAndNumber("jhfse", 12);
    }

    static boolean within10and20(int a, int b) {
        return (a + b <= 20) && (a + b >= 10);
    }

    public static void PositiveOrNegative(int num) {
        if (num >= 0) {
            System.out.println("Число " + num + "положительное");
        } else {
            System.out.println("Число " + num + " отрицательное");
        }
    }

    static boolean TrueOrFalse(int num) {
        if (num < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void StringAndNumber(String str, int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(str);
        }
    }
}
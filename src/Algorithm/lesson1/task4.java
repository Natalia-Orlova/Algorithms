package Algorithm.lesson1;

// Написать алгоритм поиска нужного числа последовательности Фибоначчи
// с помощью рекурсии. Сложность 2^n-1

import java.util.Date;

public class task4 {

    public static void main(String[] args) {
        //long start = System.currentTimeMillis();
        long start = new Date().getTime();
        System.out.println(fibRec(45));
        long finish = new Date().getTime();
        //long finish = System.currentTimeMillis();

        // Через цикл сложность алгоритма О(N)
        long start1 = new Date().getTime();
        System.out.println(fibFor(45));
        long finish1 = new Date().getTime();

        System.out.println("Время через рекурсию: " + (finish - start));
        System.out.println("Время через цикл: " + (finish1 - start1));
        }

    public static int fibRec (int position) {
        if (position == 1 || position == 2) {
            return 1;
        }
        return fibRec(position - 1) + fibRec(position - 2);
    }

    public static int fibFor(int pos) {
        int num1 = 0;
        int num2 = 1;
        for (int i = 1; i < pos; i++) {
            int k = num2;
            num2+= num1;
            num1 = k;
        }
        return num2;
    }

}

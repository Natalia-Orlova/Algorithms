package Algorithm.lesson2;

// https://java-lessons.ru/date-time/measure-elapsed-time замерить время выполнения алгоритма
// (int)(Math.random() * 100); для заполнения массива рандомными числами

import java.time.Duration;
import java.time.Instant;

import static Algorithm.lesson2.lecture2.bubbleSort;
import static Algorithm.lesson2.lecture2.quickSort;


public class seminar2 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = (int)Math.floor(Math.random() * 100);
        }
        Instant start = Instant.now();
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("\nВремя сортировки bubbleSort: " + elapsed);

        Instant start1 = Instant.now();
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        Instant finish1 = Instant.now();
        long elapsed1 = Duration.between(start1, finish1).toMillis();
        System.out.println("\nВремя сортировки quickSort: " + elapsed1);

    }
}

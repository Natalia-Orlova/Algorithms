package Algorithm.lesson1;

// Написать алгоритм поиска простых чисел в диапазоне от 1 до N. В алгоритме
// будет использоваться вложенный for, что говорит о квадратичной сложности,
// на этом стоит акцентировать внимание. Сложность O(n^2)

import java.util.ArrayList;
import java.util.List;

public class task2 {
    public static void main(String[] args) {
        List<Integer> primeNumbers = findPrimeNums(100);
        for (Integer integer : primeNumbers) {
            System.out.print(integer + " ");
        }
    }

    public static List<Integer> findPrimeNums(int n) {
        int counter = 0;
        List<Integer> primeNums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean simple = true; // переменная для проверки, является ли i простым числом
            for (int j = 2; j < i; j++) { // начинаем с 2, т.к. любое число делится на 1, и j < i, т.к. любое число делится само на себя
                counter++;
                if (i % j == 0) { // если найден делитель, то число не является простым
                    simple = false;
                    break;
                }
            }
            if (simple) { // если делителей не найдено, то число простое, записываем его в массив
                primeNums.add(i);
            }
        }
        System.out.println("Число операций: " + counter);
        return primeNums;
    }
}

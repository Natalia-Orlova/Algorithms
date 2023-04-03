package Algorithm.lesson1;// Написать алгоритм, считающий сумму всех чисел от 1 до N.
// Согласно свойствам линейной сложности, количество итераций цикла будет линейно
// изменяться относительно изменения размера N. Сложность O(n).

public class task1 {
    public static void main(String[] args) {
        System.out.println("Сумма чисел от 1 до n: " + Sum(10));
    }

    public static int Sum (int n) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            count +=1;
        }
        System.out.println("Число операций: " + count);
        return sum;
    }
}


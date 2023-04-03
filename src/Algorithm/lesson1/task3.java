package Algorithm.lesson1;

// Необходимо написать алгоритм поиска всех доступных комбинаций (посчитать количество)
// для количества кубиков К с количеством граней N.
// 2 варианта на выбор: кол-во кубиков может быть строго ограничено, либо их кол-во
// будет динамическим.

import java.util.ArrayList;
import java.util.List;

public class task3 {
    public static void main(String[] args) {
       findComb(6);

    }

    public static void findComb(int n){
        int count = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                for (int l = 1; l <= n ; l++) {
                    System.out.printf("%d %d %d\n", i, j, l);
                    count++;
                }
            }

        }
        System.out.println("Количество комбинаций: " + count);
    }
}

package Algorithm.lesson2;

public class lecture2 {


    public static void main(String[] args) {
        int[] array = new int[] {5,6,8,9,0,6,4,4,5,3};
        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        //System.out.println(binarySearch(array, 9));
    }

    // СОРТИРОВКА ПУЗЫРЬКОМ. СЛОЖНОСТЬ КВАДРАТИЧНАЯ O(N^2), т.к. 2 вложенных цикла
    public static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp; // проходим по циклу, пока не нужно будет совершать обмен элементов
                    finish = false;
                }

            }
        } while (!finish);
    }

    // СОРТИРОВКА ВЫБОРОМ. СЛОЖНОСТЬ КВАДРАТИЧНАЯ O(N^2), т.к. тоже 2 вложенных цикла,
    // НО КОЛ-ВО ОПЕРАЦИЙ МЕНЬШЕ, ЧЕМ В ПУЗЫРЬКОВОЙ СОРТИРОВКЕ
    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    // СОРТИРОВКА ВСТАВКОЙ. СЛОЖНОСТЬ КВАДРАТИЧНАЯ,
    // НА БОЛЬШОМ ОБЪЕМЕ ДАННЫХ ПЛОХАЯ ПРОИЗВОДИТЕЛЬНОСТЬ
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    // АЛГОРИТМ ПОИСКА ЭЛЕМЕНТА В МАССИВЕ. СЛОЖНОСТЬ O(N)
    public static int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1; // если элемента нет в массиве
    }

    //ФУНКЦИЯ БИНАРНОГО ПОИСКА РЕКУРСИВНО ("РАЗДЕЛЯЙ И ВЛАСТВУЙ")
    // НУЖНА ПРЕДВАРИТЕЛЬНАЯ СОРТИРОВКА МАССИВА!
    // СЛОЖНОСТЬ O(log n). ПРОИЗВОДИТЕЛЬНОСТЬ ВЫШЕ, ЧЕМ O(N)

    public static int binarySearch(int[] array, int value) {  //ПЕРЕГРУЗКА МЕТОДА, ЧТОБЫ В МЕСТЕ ЕГО ВЫЗОВА
        return binarySearch(array, value, 0, array.length - 1); // НЕ ПРОПИСЫВАТЬ MIN/MAX
    }
    public static int binarySearch (int[] array, int value, int min, int max) {
        int midpoint;
        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min; // вычисляем позицию середины указанного отрезка
        }

        if (array[midpoint] < value) { // если средний элемент меньше искомого, то продолжаем поиск
            return binarySearch(array, value, midpoint + 1, max); // рекурсивно в правой части массива
        } else {
            if (array[midpoint] > value) { // если больше искомого, то ищем в левой части массива
                return binarySearch(array, value, min, midpoint - 1);
            } else {
                return midpoint; // если array[midpoint] == value
            }
        }
    }

    // БЫСТРАЯ СОРТИРОВКА QUICK SORT. СЛОЖНОСТЬ O(n*log n)
    // работает по принципу "разделяй и властвуй"
    //максимально возможная сложность - O(n^2) в случае, когда массив уже отсортирован
    // и в качестве пивота взят элемент в начале массива
    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);

        if (leftPosition < endPosition) {
            quickSort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition) {
            quickSort(array, startPosition, rightPosition);
        }
    }

    //ПИРАМИДАЛЬНАЯ СОРТИРОВКА. СЛОЖНОСТЬ O(n*log n)

    public static void sort(int[] array) {
        //Построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >= 0 ; i--) { // берем середину массива в кач-ве корня
            heapify(array, array.length, i); //запускаем просеивание
        }

        //Один за другим извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0 ; i--) {
            //Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //Вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }
    //базовая операция просеивания
    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex; // инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый ребенок, по формуле 2 * i + 1
        int rightChild = 2 * rootIndex + 2; // правый ребенок 2 * i + 2

        // Если левый ребенок больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        //Если дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        //Если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }

}

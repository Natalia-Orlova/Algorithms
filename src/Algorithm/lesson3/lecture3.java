package Algorithm.lesson3;
// СТРУКТУРЫ ДАННЫХ. СВЯЗНЫЙ СПИСОК
public class lecture3 {
    Node head; //описывает начало списка
    Node tail; // описывает последний элемент списка. Используется только в 2-связном списке

    //метод удаления. Константная сложность
    public void delete (Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) { // если нода является head
            next.previous = null; // удаляем 1 элемент списка и началом является следующий элемент
            head = next;
        }else {
            if (next == null) { // если нода посдедний элемент
                previous.next = null; // удаляем последний элемент
                tail = previous; // и назначаем tail
            } else {
                previous.next = next;
                next.previous = previous;//когда нода в середине и у нее есть prev и next
            }
        }
    }


    // метод вставки элемента в список
    public void add (int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) { // если список пустой
            head = node;
            tail = node;
        }
        else {
            tail.next = node; //добавляем элемент в конец списка
            node.previous = tail;
            tail = node;
        }
    }

    //метод добавления элемента в список после определенной ноды
    public void add(int value, Node node) {
        Node next = node.next; //указывает на следующий элемент после указанной ноды
        Node newNode = new Node(); // нода, которую вставляем
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null) { // если указанная нода является последним элементом
            tail = newNode; // обновляем tail, происходит вставка в конец списка
        } else {
            next.previous = newNode; // вставка в середину между указанной нодой и следующей за ней
            newNode.next = next;
        }
    }

    // метод поиска элемента в списке. Сложность O(n).
    public Node find (int value) {
        Node currentNode = head;
        while (currentNode != null) { // пока текущая нода не равна null
            if (currentNode.value == value) { // если текущая нода равна искомому значению
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null; // если не нашлось элемента в списке
    }

    // метод разворота 2-связного списка
    public void revert(){
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous; // меняем их местами
            currentNode.previous = next;
            if (previous == null) { // если находимся в head
                tail = currentNode; // меняем ее на tail
            }
            if (next == null) { // если это последний элемент
                head = currentNode; // меняем его на head
            }
            currentNode = next;
        }
    }

    // разворот односвязного списка с помощью рекурсии
    public void revertSingly() {
        if (head != null && head.next != null) { // разворот запускаем только если в списке есть хотя бы 2 ноды
            Node temp = head;
            revert(head.next, head);
            temp.next = null; // т.к. head не обрабатывается рекурсивно, здесь присваиваем след.значению null
                                //тем самым происходит разворот, head становится tail
        }
    }

    // разворот двусвязного списка
    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode; // последняя нода становится началом
        } else {
            revert (currentNode.next, currentNode);
        }
        currentNode.next = previousNode; // замена ссылок

    }

    // метод добавления значения в начало стека
    public void push (int value) {
        Node node = new Node(); // формируем ноду
        node.value = value;
        node.next = head;
        // head.previous = node; // эта строка добавляется в метод для 2связного списка
        head = node;
    }

    // метод извлечения элемента из стека (всегда извлекает последний элемент стека)
    public Integer pop() { // используем Integer, чтобы возвращалось null, если очередь пустая
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }

    // метод извлечения последнего элемента из очереди. (для очереди вместо pop)
    public Integer peek() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null; // предыдущий элемент становится последним
            tail = tail.previous; //назначаем для tail предыдущий элемент
        }
        return result;
    }



    public class Node {
        int value; //значение ноды
        Node next; //описывает следующий элемент списка
        Node previous; //описывает предыдущий элемент

    }
}

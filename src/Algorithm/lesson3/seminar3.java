package Algorithm.lesson3;

public class seminar3 {
    // СОРТИРОВКА СВЯЗНОГО СПИСКА
    Node head;
    public void sortList()
    {
        Node current = head, index = new Node();
        int temp;

        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                index = current.next;
                while (index != null) {
                    if (current.value > index.value) {
                        temp = current.value;
                        current.value = index.value;
                        index.value = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public class Node {
        int value; //значение ноды
        Node next; //описывает следующий элемент списка
        Node previous; //описывает предыдущий элемент

    }
}

//package Algorithm.lesson3;
//
//public class seminar3 {
//    public void sortList()
//    {
//        Node current = head, index = new Node();
//        int temp;
//
//        if (head == null) {
//            return;
//        }
//        else {
//            while (current != null) {
//                index = current.nextNode;
//                while (index != null) {
//                    if (current.value > index.value) {
//                        temp = current.value;
//                        current.value = index.value;
//                        index.value = temp;
//                    }
//
//                    index = index.nextNode;
//                }
//                current = current.nextNode;
//            }
//        }
//    }
//}

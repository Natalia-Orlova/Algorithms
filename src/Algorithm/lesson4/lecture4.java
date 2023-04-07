//package Algorithm.lesson4;
//
//// СТРУКТУРЫ ДАННЫ ДЕРЕВО И ХЭШ-ТАБЛИЦЫ
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class lecture4 {
//    Node root;
//
//    //ОБХОД ДЕРЕВА В ГЛУБИНУ РЕКУРСИВНО. ПОИСК ЗНАЧЕНИЯ
//    private Node find (Node node, int value) {
//        if (node.value == value) { // если нода содержит интересующее значение
//            return node;
//        } else { // есди нет, то перебираем детей
//            for(Node child : node.children) {
//                Node result = find(child, value);
//                if (result != null) {
//                    return result;
//                }
//            }
//        }
//        return null; // если в структуре данных нет искомого значения
//    }
//    public boolean exists(int value){
//        if (root != null) { // если дерево не пустое
//            Node node = find(root, value);
//            if (node != null) { // если нашли ноду с интерес значением
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//
//    // ОБХОД ДЕРЕВА В ШИРИНУ (ЦИКЛИЧНО). более ресурсозатратен, чем обход в глубину.
//    private Node find(int value) {
//        List<Node> line = new ArrayList<>();
//        line.add(root);
//        while (line.size() > 0) { // пока в объекте существуют дети
//            List<Node> nextLine = new ArrayList<>();
//            for (Node node : line) {
//                if (node.value == value) {
//                    return node;
//                }
//                nextLine.addAll(node.children);
//            }
//            line = nextLine;
//        }
//        return null;
//    }
//
//    // БИНАРНОЕ ДЕРЕВО - ЧАСТНЫЙ СЛУЧАЙ ДЕРЕВА, ГДЕ ВСЕ ЭЛЕМЕНТЫ СТРОГО УНИКАЛЬНЫ,
//    // КАЖДЫЙ РОДИТЕЛЬ ИМЕЕТ НЕ БОЛЕЕ 2 ДЕТЕЙ, ПРИ ЭТОМ ЛЕВЫЙ РЕБЕНОК ВСЕГДА МЕНЬШЕ РОДИТЕЛЯ,
//    // А ПРАВЫЙ ВСЕГДА БОЛЬШЕ РОДИТЕЛЯ.
//
//    // СБАЛАНСИРОВАННОЕ ДЕРЕВО - ЧАСТНЫЙ СЛУЧАЙ БИНАРНОГО ДЕРЕВА, У КОТОРОГО ВЫПОЛНЯЕТСЯ СЛЕД ТРЕБОВАНИЕ:
//    // ДЛЯ ЛЮБОГО УЗЛА ДЕРЕВА ВЫСОТА ЕГО ПРАВОГО ПОДДЕРЕВА ОТЛИЧАЕТСЯ ОТ ВЫСОТЫ ЛЕВОГО ПОДДЕРЕВА НЕ БОЛЕЕ
//    // ЧЕМ НА ЕДИНИЦУ. ГЛУБИНА СЛЕВА И СПРАВА ВСЕГДА ПРИМЕРНО ОДИНАКОВА
//    // СЛОЖНОСТЬ ПОИСКА ПО СБАЛАНСИРОВАННОМУ ДЕРЕВУ  O(log*n)
//
//    // КРАСНО-ЧЕРНОЕ ДЕРЕВО
//    // - каждый узел может быть либо черным, либо красным и иметь 2 потомков
//    // - корень всегда черный
//    // - дети красного узла всегда черные
//    // для ЛЕВОСТОРОННЕГО КРАСНО-ЧЕРНОГО ДЕРЕВА: красный узел может быть только левым потомком
//
//
//
//    public class Node{
//        int value;
//        List<Node> children;
//    }
//}

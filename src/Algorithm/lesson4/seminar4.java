package Algorithm.lesson4;

public class seminar4 {

    public class Hash <Key, Value> {

        private static final double loadFactor = 0.75;
        private static int size = 10;
        private Basket[] baskets;

        public Hash (){
            this(size);
        }

        public Hash (int size) {
            baskets = (Basket[]) new Object[size];
        }

        private int getIndex (Key key) {
            return Math.abs(key.hashCode()) % baskets.length;
        }

        private Value get (Key key) {
            int index = getIndex(key);
            Basket basket = baskets[index];
            if (basket != null) {
                return basket.getValue(key);
            }
            return null;
        }

        public boolean put (Key key, Value value) {
            if (baskets.length * loadFactor < size) {
                reload();
            }
            int index = getIndex(key);
            Basket basket = baskets[index];
            if (basket == null) {
                basket = new Basket();
                baskets[index] = basket;
            }
            Entity entity = new Entity();
            entity.key = key;
            entity.value = value;

            if (basket.add(entity)) {
                size++;
                return true;
            }
            return false;
        }

        public boolean remove (Key key) {
            int index = getIndex(key);
            Basket basket = baskets[index];
            if (basket.remove(key)) {
                size--;
                return true;
            }
            return false;
        }

        // расширить баскеты, если один баскет заполнен на 75%
        private void reload() {
            Basket[] old = baskets;
            baskets = (Basket[]) new Object[old.length * 2];
            for (int i = 0; i < old.length; i++) {
                Basket basket = old[i];
                Basket.Node node = basket.head;
                while (node != null) {
                    put(node.value.key, node.value.value);
                    node = node.next;
                }
                old[i] = null;
            }
        }

        private class Basket {
            private Node head;

            private Value getValue (Key key) {
                Node node = head;
                while (node != null) {
                    if (node.value.key.equals(key)) {
                        return node.value.value;
                    }
                    node = node.next;
                }
                return null;
            }

            // добавление элементов в хэш-таблицу
            public boolean add (Entity entity) {
                Node node = new Node();
                node.value = entity;
                if (head == null) {
                    head = node;
                    return true;
                } else {
                    Node currentNode = head;
                    while (currentNode.next != null) {
                        if (currentNode.value.key.equals(entity.key)) {
                            return false;
                        }
                        currentNode = currentNode.next;
                    }
                    currentNode.next = node;
                    return true;
                }
            }

            // удаление элементов из хэш-таблицы
            public boolean remove (Key key) {
                if (head != null) {
                    if (head.value.key.equals(key)) {
                        head = head.next;
                    }
                    Node currentNode = head;
                    while (currentNode.next != null) {
                        if (currentNode.value.key.equals(key)) {
                            currentNode.next = currentNode.next.next;
                            return true;
                        }
                        currentNode = currentNode.next;
                    }
                }
                return false;
            }
            private class Node {
                private Node next;
                private Entity value;
            }
        }

        private class Entity {
            private Key key;
            private Value value;
        }

    }
}

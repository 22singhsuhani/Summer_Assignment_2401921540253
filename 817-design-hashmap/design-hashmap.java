class MyHashMap {

    private class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] map;
    private final int SIZE = 1000;

    public MyHashMap() {
        map = new Node[SIZE];
    }

    public void put(int key, int value) {
        int index = key % SIZE;

        Node curr = map[index];

       
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

       
        Node newNode = new Node(key, value);
        newNode.next = map[index];
        map[index] = newNode;
    }

    public int get(int key) {
        int index = key % SIZE;
        Node curr = map[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = key % SIZE;
        Node curr = map[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {

                if (prev == null) {
                    map[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }

                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}

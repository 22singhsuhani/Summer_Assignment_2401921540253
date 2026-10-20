class FrontMiddleBackQueue {
    LinkedList<Integer> left = new LinkedList<>();
    LinkedList<Integer> right = new LinkedList<>();

    public FrontMiddleBackQueue() {}

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() < right.size()) {
            left.addLast(val);
        } else {
            right.addFirst(val);
        }
        balance();
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty()) return -1;

        int val;
        if (!left.isEmpty()) val = left.removeFirst();
        else val = right.removeFirst();

        balance();
        return val;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) return -1;

        int val;
        if (left.size() == right.size()) {
            val = left.removeLast();
        } else {
            val = right.removeFirst();
        }

        balance();
        return val;
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty()) return -1;

        int val;
        if (!right.isEmpty()) val = right.removeLast();
        else val = left.removeLast();

        balance();
        return val;
    }

    private void balance() {
        while (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }

        while (right.size() > left.size() + 1) {
            left.addLast(right.removeFirst());
        }
    }
}
package section5;

public class SparseArray {
    private Node head;
    private Node tail;
    private int size;
    private final int capacity;

    public SparseArray(int capacity) {
        this.capacity = capacity;
    }

    public void set(int index, int value) {
        insertSorted(index, value);
    }

    public void insertSorted(int index, int value) {
        if (size == 0 || index < head.index) {
            insertFront(index, value);
            return;
        }
        if (index > tail.index) {
            insert(index, value);
            return;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.index == index) {
                curr.value = value;
                return;
            } else if (curr.index > index) {
                Node node = new Node(index, value);
                link(prev, node);
                link(node, curr);
                size++;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    private void insert(int index, int value) {
        Node node = new Node(index, value);
        if (size == 0) {
            head = node;
        } else {
            link(tail, node);
        }
        tail = node;
        size++;
    }

    private void insertFront(int index, int value) {
        Node node = new Node(index, value);
        if (size == 0) {
            tail = node;
        } else {
            link(node, head);
        }
        head = node;
        size++;
    }

    public int get(int index) {
        Node curr = head;
        while (curr != null && curr.index <= index) {
            if (curr.index == index) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void add(SparseArray array) {
        Node prev1 = null;
        Node curr1 = head;
        Node curr2 = array.head;
        while (curr2 != null) {
            if (curr1 == null) {
                Node next = curr2.next;
                link(tail, curr2);
                tail = curr2;
                tail.next = null;
                curr2 = next;
            } else if (curr1.index == curr2.index) {
                curr1.value += curr2.value;
                prev1 = curr1;
                curr1 = curr1.next;
                curr2 = curr2.next;
            } else if (curr1.index > curr2.index) {
                Node next = curr2.next;
                link(prev1, curr2);
                link(curr2, curr1);
                curr2 = next;
            } else {
                prev1 = curr1;
                curr1 = curr1.next;
            }
        }

    }


    private void link(Node first, Node second) {
        if (first != null) {
            first.next = second;
        } else {
            head = second;
        }
        if (second != null) {
            second.prev = first;
        }else {
            tail = first;
        }
    }

    public int size() {
        return capacity;
    }

    public void print() {
        Node curr = head;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            if (curr != null && curr.index == i) {
                out.append(curr.value).append(' ');
                curr = curr.next;
            } else {
                out.append(0).append(' ');
            }
        }
        System.out.println(out);
    }

    public void printNonZero() {
        Node curr = head;
        StringBuilder out = new StringBuilder();

        while (curr != null) {
            out.append(curr.value).append(' ');
            curr = curr.next;
        }
        System.out.println(out);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
//        out.append("head:").append(head).append('\n');
//        out.append("tail:").append(tail).append('\n');
//        out.append("size: ").append(size).append('\n');
        Node curr = head;
        out.append("null <-");
        while (curr != null) {
            out.append(curr);
            if (curr.next != null) {
                out.append("<=>");
            }
            curr = curr.next;
        }
        out.append("-> null");
        return out.toString();
    }

    private class Node {
        int index, value;
        Node next, prev;

        public Node() {
        }

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return " (" + index + ", " + value + ") ";
        }
    }
}

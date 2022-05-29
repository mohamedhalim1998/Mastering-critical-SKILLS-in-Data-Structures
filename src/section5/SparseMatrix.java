package section5;

public class SparseMatrix {
    private Node head;
    private Node tail;
    private int size;
    private final int rows;
    private final int cols;

    public SparseMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public void set(int value, int row, int col) {
        insertSorted(row, col, value);
    }

    public void insertSorted(int row, int col, int value) {

        if (size == 0 || row < head.row) {
            insertFront(row, col, value);
            return;
        }
        if (row > tail.row) {
            insert(row, col, value);
            return;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.row == row) {
                curr.sparseArray.set(col, value);
                return;
            } else if (curr.row > row) {
                Node node = new Node(row);
                node.sparseArray.set(col, value);
                link(prev, node);
                link(node, curr);
                size++;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    private void insert(int row, int col, int value) {
        Node node = new Node(row);
        node.sparseArray.set(col, value);
        if (size == 0) {
            head = node;
        } else {
            link(tail, node);
        }
        tail = node;
        size++;
    }

    private void insertFront(int row, int col, int value) {
        Node node = new Node(row);
        node.sparseArray.set(col, value);
        if (size == 0) {
            tail = node;
        } else {
            link(node, head);
        }
        head = node;
        size++;
    }

    public int get(int row, int col) {
        Node curr = head;
        while (curr != null && curr.row <= row) {
            if (curr.row == row) {
                return curr.sparseArray.get(col);
            }
            curr = curr.next;
        }
        return -1;
    }

    public void add(SparseMatrix array) {
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
            } else if (curr1.row == curr2.row) {
                curr1.sparseArray.add(curr2.sparseArray);
                prev1 = curr1;
                curr1 = curr1.next;
                curr2 = curr2.next;
            } else if (curr1.row > curr2.row) {
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



    public void print() {
        Node curr = head;
        for (int i = 0; i < rows; i++) {
            if (curr != null && curr.row == i) {
                curr.sparseArray.print();
                curr = curr.next;
            } else {
                StringBuilder out = new StringBuilder();
                for (int j = 0; j < cols; j++) {
                    out.append(0).append(' ');
                }
                System.out.println(out);
            }
        }
    }

    public void printNonZero() {
        Node curr = head;
        while (curr != null) {
            curr.sparseArray.printNonZero();
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
//        out.append("tail:").append(tail).append('\n');
//        out.append("size: ").append(size).append('\n');
        Node curr = head;
        while (curr != null) {
            out.append("row:").append(curr.row).append('\n');
            out.append(curr.sparseArray.toString());
            out.append("\n");
            curr = curr.next;
        }
//        out.append("-> null");
        return out.toString();
    }

    private class Node {
        int row;
        SparseArray sparseArray;
        Node next, prev;

        public Node(int row) {
            this.row = row;
            this.sparseArray = new SparseArray(cols);
        }

        public Node() {
        }

        public Node(int row, int value) {
            this.row = row;
        }


        @Override
        public String toString() {
            return " " + row + " ";
        }
    }
}

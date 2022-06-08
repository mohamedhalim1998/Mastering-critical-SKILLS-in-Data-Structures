
import java.util.Objects;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    int size;

    public void insert(int x) {
        Node node = new Node(x);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insertSorted(int x) {
        Node node = new Node(x);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            Node curr = head;
            Node prev = null;
            while (curr != null && curr.x < x) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) {
                node.next = curr;
                prev.next = node;
            } else {
                node.next = head;
                head = node;
            }
        }
        size++;
    }

    public void insertFront(int x) {
        Node node = new Node(x);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public int deleteFront() {
        if (size == 0) {
            throw new RuntimeException("delete from an empty list");
        }
        int item = head.x;
        head = head.next;
        size--;
        return item;
    }

    public int deleteLast() {
        if (size == 0) {
            throw new RuntimeException("delete from an empty list");
        }
        if (size == 1) {
            int item = head.x;
            head = null;
            tail = null;
            return item;
        }
        Node curr = head;
        Node prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        tail = prev;
        if (prev != null)
            tail.next = null;
        size--;
        return curr.x;
    }

    public int delete(int index) {
        if (index >= size) {
            throw new RuntimeException("request index not found");
        }

        Node curr = head;
        Node prev = null;
        int i = 0;
        if (index == 0) {
            deleteFront();
        }
        while (i < index) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        if (prev != null) {
            prev.next = curr.next;
        }

        size--;
        return curr.x;
    }

    public int deleteValue(int value) {
        Node curr = head;
        Node prev = null;
        if (curr.x == value) {
            deleteFront();
        }
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
            if (curr.x == value) {
                prev.next = curr.next;
                size--;
                return curr.x;
            }
        }
        throw new RuntimeException("value not found");
    }

    public void swapPairsPointers() {
        if (size < 2) {
            return;
        }
        Node node1 = head;
        Node node2 = head.next;
        Node prev = null;
        if (node2 != null) {
            node1.next = node2.next;
            node2.next = node1;
            head = node2;
            prev = node1;
            node1 = node1.next;
            if (node1 != null)
                node2 = node1.next;
        }

        while (node1 != null && node2 != null) {
            prev.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            prev = node1;
            node1 = node1.next;
            if (node1 != null)
                node2 = node1.next;
        }
        if (node1 != null)
            tail = node1;
        else
            tail = prev;
    }

    public void swapPairsValues() {
        if (size < 2) {
            return;
        }
        Node node1 = head;


        while (node1 != null && node1.next != null) {
            Node node2 = node1.next;
            int temp = node1.x;
            node1.x = node2.x;
            node2.x = temp;
            node1 = node1.next.next;
//                node1 = node1.next;
        }


    }

    public void reverse() {
        if (size < 2) {
            return;
        }
        Node[] nodes = new Node[size];
        int index = 0;
        Node curr = head;
        while (curr != null) {
            nodes[index++] = curr;
            curr = curr.next;
        }
        for (int i = 0; i < size; i++) {
            nodes[i].next = null;
        }
        for (int i = size - 2; i >= 0; i--) {
            nodes[i + 1].next = nodes[i];
        }
        head = nodes[size - 1];
    }

    public void reverseInPlace() {
        if (size < 2) {
            return;
        }
        tail = head;
        Node prev = head;
        head = head.next;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head = prev;
        tail.next = null;
    }

    public void deleteEven() {
        Node curr = head;
        Node prev = null;
        int i = 0;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
            if (i % 2 == 0) {
                prev.next = curr.next;
                size--;
            }
            i++;
        }


    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node node = head;
        int i = 0;
        while (i < index && node.next != null) {
            i++;
            node = node.next;
        }
        if (i == index) {
            return node.x;
        }
        return -1;
    }

    public int getFromBack(int index) {
        return get(size - index - 1);
    }

    public int search(int item) {
        if (size == 0) {
            return -1;
        }
        Node node = head;
        int index = 0;
        while (node != null && node.x != item) {
            node = node.next;
            index++;
        }
        if (node != null)
            return index;
        return -1;
    }

    public int improvedSearch(int item) {
        if (size == 0) {
            return -1;
        }
        Node node = head;
        int index = 0;
        Node prev = null;
        while (node != null && node.x != item) {
            prev = node;
            node = node.next;
            index++;
        }
        if (node != null) {
            if (prev != null) {
                int temp = node.x;
                node.x = prev.x;
                prev.x = temp;
            }
            return index;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("SingleLinkedList{");
        Node node = head;
        if (node != null) {
            while (node.next != null) {
                out.append(node.x).append(", ");
                node = node.next;
            }
            out.append(node.x);
        }
        out.append("}");
        return out.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedList that = (SinglyLinkedList) o;
        if (size != that.size)
            return false;
        Node n1 = this.head;
        Node n2 = that.head;
        while (n1 != null && n2 != null) {
            if (!n1.equals(n2)) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    private class Node {
        private int x;
        private Node next;

        public Node(int x) {
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    '}';
        }
    }

}

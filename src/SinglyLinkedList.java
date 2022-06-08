import org.w3c.dom.Node;

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
    }

}

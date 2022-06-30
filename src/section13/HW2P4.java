package section13;


import java.util.HashSet;
import java.util.Objects;

public class HW2P4 {

    public static class SinglyLinkedList {
        private SinglyLinkedList.Node head;
        private SinglyLinkedList.Node tail;
        int size;

        public void insert(int x) {
            SinglyLinkedList.Node node = new SinglyLinkedList.Node(x);
            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public void createCycle() {
            for (int i = 0; i < 4; ++i)
                insert(i);
            Node now = tail;
            for (int i = 0; i < 3; ++i)
                insert(14 + i);
            tail.next = now;// cycle
        }

        public void removeCycle() {
            Node curr = head;
            Node prev = null;
            HashSet<Integer> set = new HashSet<>();
            while (!set.contains(curr.value)) {
                set.add(curr.value);
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
        }

        @Override
        public String toString() {
            StringBuilder out = new StringBuilder();
            out.append("SingleLinkedList{");
            SinglyLinkedList.Node node = head;
            if (node != null) {
                while (node.next != null) {
                    out.append(node.value).append(", ");
                    node = node.next;
                }
                out.append(node.value);
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
            SinglyLinkedList.Node n1 = this.head;
            SinglyLinkedList.Node n2 = that.head;
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


        public boolean isEmpty() {
            return head == null;
        }

        private class Node {
            private int value;
            private SinglyLinkedList.Node next;

            public Node(int value) {
                this.value = value;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                SinglyLinkedList.Node node = (SinglyLinkedList.Node) o;
                return value == node.value;
            }

            @Override
            public int hashCode() {
                return Objects.hash(value);
            }

            @Override
            public String toString() {
                return "Node{" +
                        "value=" + value +
                        '}';
            }
        }

    }

}

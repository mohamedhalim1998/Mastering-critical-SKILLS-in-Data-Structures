package section13;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class HW1P5 {

    public static int hashString(String str, int n) {
        long sum = 0;
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            int s = 0;
            if (Character.isUpperCase(c)) {
                s = 26 + c - 'A';
            } else if (Character.isLowerCase(c)) {
                s = c - 'a';
            } else {
                s = 2 * 26 + c - '0';
            }
            sum = (sum + s * (2 * 26 + 10)) % n;
        }

        return (int) (sum % n);
    }


    public static class HashTable {
        ArrayList<SinglyLinkedList> table;
        int capacity;
        double loadFactor;
        double limitLoadFactor;
        int size;

        public HashTable(int capacity, double limitLoadFactor) {
            this.capacity = capacity;
            this.table = new ArrayList<>();
            this.limitLoadFactor = limitLoadFactor;
            for (int i = 0; i < capacity; i++) {
                table.add(new SinglyLinkedList());
            }
        }

        public void put(PhoneEntry phoneEntry) {
            int index = phoneEntry.hashCode(capacity);
            for (PhoneEntry p : table.get(index)) {
                if (Objects.equals(p.name, phoneEntry.name)) {
                    p.phone = phoneEntry.phone;
                    return;
                }
            }
            table.get(index).insert(phoneEntry);
            size++;
            updateLoadFactor();
        }

        private void updateLoadFactor() {
            loadFactor = size * 1.0 / capacity;
            if (loadFactor > limitLoadFactor) {
                rehash();
                loadFactor = size * 1.0 / capacity;
            }
        }

        private void rehash() {
            capacity = 2 * capacity;
            ArrayList<SinglyLinkedList> old = table;
            table = new ArrayList<>();
            for (int i = 0; i < capacity; i++) {
                table.add(new SinglyLinkedList());
            }
            for (SinglyLinkedList phoneEntries : old) {
                for (PhoneEntry phoneEntry : phoneEntries) {
                    put(phoneEntry);
                }
            }
        }

        public boolean get(PhoneEntry phoneEntry) {
            int index = phoneEntry.hashCode() % capacity;
            for (PhoneEntry p : table.get(index)) {
                if (Objects.equals(p, phoneEntry)) {
                    return true;
                }
            }
            return false;
        }

        public boolean remove(PhoneEntry phoneEntry) {
            int index = phoneEntry.hashCode() % capacity;
            return table.get(index).deleteValue(phoneEntry) != null;
        }

        public void printAll() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            return table.toString();
        }


    }

    public static class PhoneEntry {
        String name;
        String phone;

        public PhoneEntry(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PhoneEntry that = (PhoneEntry) o;
            return Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
        }


        public int hashCode(int capacity) {
            return hashString(name, capacity);
        }

        @Override
        public String toString() {
            return "PhoneEntry{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    public static class SinglyLinkedList implements Iterable<PhoneEntry> {
        private Node head;
        private Node tail;
        int size;

        public void insert(PhoneEntry x) {
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


        public void insertFront(PhoneEntry x) {
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


        public PhoneEntry deleteFront() {
            if (size == 0) {
                throw new RuntimeException("delete from an empty list");
            }
            PhoneEntry item = head.value;
            head = head.next;
            size--;
            return item;
        }


        public PhoneEntry deleteValue(PhoneEntry value) {
            Node curr = head;
            Node prev = null;
            if (curr.value.equals(value)) {
                return deleteFront();
            }
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
                if (curr.value == value) {
                    prev.next = curr.next;
                    size--;
                    return curr.value;
                }
            }
            throw new RuntimeException("value not found");
        }


        @Override
        public String toString() {
            StringBuilder out = new StringBuilder();
            out.append("SingleLinkedList{");
            Node node = head;
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


        public boolean isEmpty() {
            return head == null;
        }

        @Override
        public Iterator<PhoneEntry> iterator() {
            return new Iterator<PhoneEntry>() {

                Node node = head;

                @Override
                public boolean hasNext() {
                    return node != null;
                }

                @Override
                public PhoneEntry next() {
                    PhoneEntry value = node.value;
                    node = node.next;
                    return value;
                }
            };
        }

        @Override
        public void forEach(Consumer<? super PhoneEntry> action) {
            Iterable.super.forEach(action);
        }

        @Override
        public Spliterator<PhoneEntry> spliterator() {
            return Iterable.super.spliterator();
        }


        private class Node {
            private PhoneEntry value;
            private Node next;

            public Node(PhoneEntry value) {
                this.value = value;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
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

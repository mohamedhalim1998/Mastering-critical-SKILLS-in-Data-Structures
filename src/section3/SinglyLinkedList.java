package section3;

import java.util.HashSet;
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
            while (curr != null && curr.value < x) {
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

    public SinglyLinkedList insertAlternate(SinglyLinkedList that) {
        Node c1 = this.head;
        Node c2 = that.head;
        boolean isThis = true;
        SinglyLinkedList newList = new SinglyLinkedList();
        while (c1 != null || c2 != null) {
            if (c1 == null) {
                newList.insert(c2.value);
                c2 = c2.next;
            } else if (c2 == null) {
                newList.insert(c1.value);
                c1 = c1.next;
            } else if (isThis) {
                newList.insert(c1.value);
                c1 = c1.next;
                isThis = false;
            } else {
                newList.insert(c2.value);
                c2 = c2.next;
                isThis = true;
            }

        }
        return newList;
    }

    public SinglyLinkedList addNumber(SinglyLinkedList that) {
        SinglyLinkedList list = new SinglyLinkedList();
        Node c1 = this.head;
        Node c2 = that.head;
        int rem = 0;
        while (c1 != null || c2 != null) {
            int sum = 0;
            if (c1 == null) {
                sum = c2.value + rem;
                c2 = c2.next;
            } else if (c2 == null) {
                sum = c1.value + rem;
                c1 = c1.next;
            } else {
                sum = c1.value + c2.value + rem;
                c1 = c1.next;
                c2 = c2.next;
            }
            if (sum > 9) {
                rem = 1;
                sum = sum - 10;
            } else {
                rem = 0;
            }
            list.insert(sum);
        }
        if (rem > 0) {
            list.insert(rem);
        }
        return list;
    }

    public int deleteFront() {
        if (size == 0) {
            throw new RuntimeException("delete from an empty list");
        }
        int item = head.value;
        head = head.next;
        size--;
        return item;
    }

    public int deleteLast() {
        if (size == 0) {
            throw new RuntimeException("delete from an empty list");
        }
        if (size == 1) {
            int item = head.value;
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
        return curr.value;
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
        return curr.value;
    }

    public int deleteValue(int value) {
        Node curr = head;
        Node prev = null;
        if (curr.value == value) {
            deleteFront();
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

    public void removeDuplicatesWithSet() {
        if (size < 2) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Node prev = null;
        Node curr = head;
        while (curr.next != null) {
            if (set.contains(curr.value)) {
                prev.next = curr.next;
                size--;
            } else {
                set.add(curr.value);
                prev = curr;
            }
            curr = curr.next;
        }
        if (set.contains(curr.value)) {
            prev.next = null;
            size--;
            tail = prev;
        }
    }

    public void removeDuplicates() {
        if (size < 2) {
            return;
        }
        Node node = head;
        Node curr = head.next;
        Node prev = head;
        while (node != null) {
            curr = node.next;
            while (curr != null) {
                if (node.value == curr.value) {

                    prev.next = curr.next;
                    if (curr.next == null) {
                        tail = curr;

                    }
                    size--;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }
            node = node.next;
        }
    }

    public void removeRepeated() {
        if (size < 2) {
            return;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node innerPrev = curr;
            Node innerCurr = curr.next;
            boolean repeated = false;
            while (innerCurr != null) {
                if (curr.value == innerCurr.value) {
                    repeated = true;
                    innerPrev.next = innerCurr.next;
                    if (innerCurr.next == null) {
                        tail = innerCurr;
                    }
                    size--;
                } else {
                    innerPrev = innerCurr;
                }
                innerCurr = innerCurr.next;
            }
            if (repeated) {
                if (prev == null) {
                    head = head.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        if (size == 0) {
            head = null;
            tail = null;
        }
        System.out.println(head);
        System.out.println(tail);
        System.out.println(size);
    }

    public void removeRepeatedSorted() {
        if (size < 2) {
            return;
        }
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        while (curr != null) {
            boolean removed = false;
            while (next != null && curr.value == next.value) {
                curr.next = next.next;
                next = next.next;
                removed = true;
                size--;
            }
            if (removed) {
                if (prev == null) {
                    head = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
            } else {
                prev = curr;
            }
            curr = next;
            if (curr != null)
                next = next.next;
        }
        if (prev == null) {
            tail = head;
        } else {
            tail = prev;
        }
        System.out.println(head);
        System.out.println(tail);
        System.out.println(size);
    }

    public void removeLastOccurrence(int value) {
        if (size < 1) {
            return;
        }
        Node prevLast = null;
        Node last = null;
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (curr.value == value) {
                last = curr;
                prevLast = prev;
            }
            prev = curr;
            curr = curr.next;
        }
        if (last == null) {
            return;
        }
        if (prevLast == null) {
            head = head.next;
            size--;

        } else {
            prevLast.next = last.next;
            size--;
            if (prevLast.next == null) {
                tail = prevLast;
            }
        }
    }

    public void moveToBack(int value) {
        if (size < 2) {
            return;
        }
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        int index = 1;
        while (index < size - 1 && next != null) {

            if (curr.value == value) {
                if (prev == null) {
                    head = head.next;
                } else {
                    prev.next = curr.next;
                }
                curr.next = null;
                tail.next = curr;
                tail = curr;
            } else {
                prev = curr;
            }
            curr = next;
            next = next.next;
            index++;
        }

    }

    public int max() {
        if (size == 0) {
            throw new RuntimeException("list is empty");
        }
        return maxHelper(head, head.value);
    }

    private int maxHelper(Node e, int max) {
        if (e.next == null) {
            return Math.max(e.value, max);
        }
        return maxHelper(e.next, Math.max(e.value, max));
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
            int temp = node1.value;
            node1.value = node2.value;
            node2.value = temp;
            node1 = node1.next.next;
//                node1 = node1.next;
        }


    }

    public void swapHeadTail() {
        if (size < 2) {
            return;
        }
        Node node = head;
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = head;
        tail.next = head.next;
        head.next = null;
        head = tail;
        tail = node.next;
    }

    public void arrangeOddEven() {
        if (size < 3) {
            return;
        }
        Node odd = head;
        Node even = odd.next;
        Node firstEven = even;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            if (odd.next != null)
                even = odd.next;

        }
        odd.next = firstEven;
        tail = even;
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

    public void reverseChains(int k) {
        if (size < 2) {
            return;
        }
        if (size <= k) {
            reverseInPlace();
            return;
        }
        Node curr = head;
        Node next = curr.next;
        Node first = curr;
        Node old = null;
        while (curr != null && next != null) {
            Node prev = curr;
            first = curr;
            curr = curr.next;
            for (int i = 0; i < k - 1 && curr != null; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if (old == null) {
                head = prev;
            } else {
                old.next = prev;
            }
            first.next = curr;
            old = first;
            curr = next;
        }
        tail = first;
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

    public void shiftLeft(int k) {
        k = k % size;
        Node newTail = head;
        int index = 1;
        while (index < k) {
            index++;
            newTail = newTail.next;
        }
        tail.next = head;
        head = newTail.next;
        tail = newTail;
        newTail.next = null;
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
            return node.value;
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
        while (node != null && node.value != item) {
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
        while (node != null && node.value != item) {
            prev = node;
            node = node.next;
            index++;
        }
        if (node != null) {
            if (prev != null) {
                int temp = node.value;
                node.value = prev.value;
                prev.value = temp;
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


    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
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

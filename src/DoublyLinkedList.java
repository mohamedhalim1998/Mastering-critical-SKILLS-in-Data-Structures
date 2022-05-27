import org.w3c.dom.Node;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void insertFront(int value) {
        Node node = new Node(value);
        if (size == 0) {
            tail = node;
        } else {
            link(node, head);
        }
        head = node;
        size++;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
        } else {
            link(tail, node);
        }
        tail = node;
        size++;
    }

    public void insertSorted(int value) {

        if (size == 0 || value < head.value) {
            insertFront(value);
            return;
        }
        if (value > tail.value) {
            insert(value);
            return;
        }
        Node node = new Node(value);
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.value > value) {
                link(prev, node);
                link(node, curr);
                size++;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void deleteFront() {
        if (size < 1) {
            return;
        }
        size--;
        if (size == 0) {
            tail = null;
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteEnd() {
        if (size < 1) {
            return;
        }
        size--;
        if (size == 0) {
            tail = null;
            head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deleteValue(int key) {
        if (size < 1) {
            return;
        }
        if (head.value == key) {
            deleteFront();
            return;
        }
        if (tail.value == key) {
            deleteEnd();
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.value == key) {
                link(prev, curr.next);
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void deleteAll(int key) {
        if (size < 1) {
            return;
        }
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.value == key) {
                if (prev == null) {
                    deleteFront();
                } else {
                    link(prev, curr.next);
                    size--;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        tail = prev;
    }

    public void deleteEven() {
        if (size < 2) {
            return;
        }
        Node odd = head;
        Node even = head.next;
        while (even != null && even.next != null) {
            link(odd, even.next);
            size--;
            odd = even.next;
            even = odd.next;
        }
        tail = odd;
        tail.next = null;
    }

    public void deleteOdd() {
        if (size < 2) {
            deleteFront();
            return;
        }
        Node even = head;
        Node odd = even.next;
        while (odd != null && odd.next != null) {
            link(even, odd.next);
            size--;
            even = odd.next;
            odd = even.next;
        }
        tail = even;
        tail.next = null;
    }

    public boolean isPalindrome() {
        Node front = head;
        Node back = tail;
        for (int i = 0; i < size / 2; i++, front = front.next, back = back.prev) {
            if (front.value != back.value) {
                return false;
            }
        }
        return true;
    }



    private void link(Node first, Node second) {
        if (first != null)
            first.next = second;
        if (second != null)
            second.prev = first;
    }


    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("head:").append(head).append('\n');
        out.append("tail:").append(tail).append('\n');
        out.append("size: ").append(size).append('\n');
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
        int value;
        Node next, prev;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return " " + value + " ";
        }
    }
}

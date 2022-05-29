package section4;

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

    public int getMiddle() {
        if (size < 1) {
            return -1;
        }
        Node front = head;
        Node back = tail;
        boolean moveFront = true;
        while (front != back) {
            if (moveFront) {
                front = front.next;
            } else {
                back = back.prev;
            }
            moveFront = !moveFront;
        }
        return front.value;
    }

    public int getMiddleNextOnly() {
        if (size < 1) {
            return -1;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        return slow.value;
    }

    public void swapForwardBackward(int k) {
        if (size < 2 || k > size) {
            return;
        }
        Node front = head;
        Node back = tail;
        if (k > size / 2) {
            k = size - k + 1;
        }
        for (int i = 0; i < k - 1; i++) {
            front = front.next;
            back = back.prev;
        }
        Node prevFront = front.prev;
        Node nextFront = front.next;
        Node prevBack = back.prev;
        Node nextBack = back.next;

        link(prevFront, back);
        link(front, nextBack);
        if (nextFront != back) {
            link(back, nextFront);
            link(prevBack, front);
        } else {
            link(back, front);
        }
        if (k == 1) {
            Node temp = head;
            head = tail;
            tail = temp;
        }

    }

    public void swapForwardBackwardWithoutSize(int k) {
        Node front = head;
        Node back = tail;
        for (int i = 0; i < k - 1; i++) {
            front = front.next;
            back = back.prev;
        }
        Node prevFront = front.prev;
        Node nextFront = front.next;
        Node prevBack = back.prev;
        Node nextBack = back.next;
        if (front.next == back) {
            Node temp = front;
            front = back;
            back = temp;
        }
        link(prevFront, back);
        link(front, nextBack);
        if (nextFront != back) {
            link(back, nextFront);
            link(prevBack, front);
        } else {
            link(back, front);
        }
        if (k == 1) {
            Node temp = head;
            head = tail;
            tail = temp;
        }

    }

    public void reverse() {
        if (size < 2) {
            return;
        }
        tail = head;
        Node prev = head;
        head = head.next;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        head = prev;
        tail.next = null;
    }

    public void mergeSorted(DoublyLinkedList that) {
        if (size == 0) {
            this.head = that.head;
            this.tail = that.tail;
            this.size = that.size;
            return;
        }
        if (that.size == 0) {
            return;
        }
        Node c1 = this.head;
        Node c2 = that.head;
        Node prev = null;
        while (c2 != null) {
            if (c1 == null) {
                tail.next = c2;
                c2.prev = tail;
                tail = c2;
                c2 = c2.next;
                tail.next = null;
            } else if (c1.value < c2.value) {
                prev = c1;
                c1 = c1.next;
            } else {
                Node next = c2.next;
                if (prev == null) {
                    c2.next = head;
                    c2.prev = null;
                    head = c2;
                } else {
                    prev.next = c2;
                    c2.prev = prev;
                    c2.next = c1;
                    c1.prev = c2;
                }
                c2 = next;
            }
        }
        size += that.size;

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

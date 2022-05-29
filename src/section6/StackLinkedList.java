package section6;

public class StackLinkedList {
    Node head;
    int size;


    public void push(int value) {
        Node n = new Node(value);
        n.next = head;
        head = n;
    }


    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        Node n = head;
        head = head.next;
        return n.value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return head.value;
    }


    public boolean isEmpty() {
        return head == null;
    }


    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        Node node = head;
        if (node != null) {
            while (node.next != null) {
                out.append(node.value).append(" -> ");
                node = node.next;
            }
            out.append(node.value);
        }
        return out.toString();
    }


    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

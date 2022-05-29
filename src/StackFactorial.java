import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.Stack;

public class StackFactorial {
    Node[] arr;
    int index;
    int size;

    public StackFactorial(int size) {
        this.size = size;
        this.arr = new Node[size];
    }

    public static int compute(int x) {
        StackFactorial stack = new StackFactorial(x);
        stack.push(new Node(x));
        Node node = new Node(1);
        while (!stack.isEmpty()) {
            node = stack.peek();
            if (node.res > 0) {
                stack.pop();
                if (!stack.isEmpty()) {
                    Node p = stack.pop();
                    p.res = p.n * node.res;
                    stack.push(p);
                }
            } else {
                if (node.n == 1) {
                    node.res = 1;
                } else {
                    stack.push(new Node(node.n - 1));
                }
            }
        }
        return node.res;
    }

    public void push(Node value) {
        if (isFull()) {
            throw new RuntimeException("stack is full");
        }
        arr[index++] = value;
    }

    public Node pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return arr[--index];
    }

    public Node peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is full");
        }
        return arr[index - 1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == size;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    static class Node {
        int n, res;

        public Node(int n) {
            this.n = n;
            this.res = -1;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "n=" + n +
                    ", res=" + res +
                    '}';
        }
    }
}
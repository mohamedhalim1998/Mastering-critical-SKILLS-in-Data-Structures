package section9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HW1P4 {
    public static class BinarySearchTree {
        private Node root;

        public BinarySearchTree() {

        }


        public void insert(int e) {
            if (root == null) {
                root = new Node(e);
                return;
            }
            Node parent = null;
            Node curr = root;
            while (curr != null) {
                parent = curr;
                if (curr.value > e) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            if (parent.value > e) {
                parent.left = new Node(e);
            } else {
                parent.right = new Node(e);
            }
        }

        public int kthSmallest(int k) {
            Stack<Node> stack = new Stack<>();
            stack.add(root);
            int res = -1234;
            while (!stack.isEmpty()) {
                Node curr = stack.peek();
                if (curr.left == null) {
                    k--;
                    res = curr.value;
                    if (k == 0)
                        return res;
                    curr = stack.pop();
                    while (!stack.isEmpty() && curr.right == null) {
                        curr = stack.pop();
                    }
                    if (stack.isEmpty() && curr.right == null)
                        break;
                    stack.push(curr.right);

                } else {
                    stack.push(curr.left);
                }
            }
            if (k != 0) {
                return -1234;
            }
            return res;
        }

        public void print() {
            System.out.println(this);
        }


        public void printByLevel() {
            int level = 0;
            StringBuilder out = new StringBuilder();
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                out.append("level ").append(level).append(": ");
                while (size-- > 0) {
                    Node node = queue.remove();

                    out.append(node.value).append(' ');
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                out.append('\n');
                level++;
            }
            System.out.println(out);
        }

        @Override
        public String toString() {
            return root.toString();
        }

        public static class Node {
            public Node left, right;
            private final int value;

            public Node(int value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return (left != null ? left + " " : "") + value + (right != null ? " " + right : "");
            }

        }

    }

}

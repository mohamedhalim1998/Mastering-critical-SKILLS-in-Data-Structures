package section11;

import java.util.LinkedList;
import java.util.Queue;

public class HW1P4 {
    public static class AVL {
        private Node root;

        public void enqueue(int e, int priority) {
            if (root == null) {
                root = new Node(e, priority);
                return;
            }
            enqueue(e, priority, root);
        }

        private Node enqueue(int e, int priority, Node node) {
            if (node == null) {
                return new Node(e, priority);
            }
            if (priority > node.priority) {
                node.right = enqueue(e, priority, node.right);
            } else if (priority < node.priority) {
                node.left = enqueue(e, priority, node.left);
            }
            return balance(node);

        }

        public int dequeue() {
            int res = min();
            delete(res);
            return res;
        }

        public int min() {
            if (root == null) {
                return -1;
            }
            Node curr = root;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr.value;
        }

        public void print() {
            System.out.println(this);
        }

        public boolean search(int e) {
            if (root == null) {
                return false;
            }
            return search(root, e);
        }

        private boolean search(Node node, int e) {
            if (node == null) {
                return false;
            }
            if (node.value == e) {
                return true;
            } else if (node.value > e) {
                return search(node.left, e);
            } else {
                return search(node.right, e);
            }
        }


        private int min(Node right) {
            if (right == null) {
                return -1;
            }
            Node curr = right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr.value;

        }

        public void delete(int x) {
            delete(x, root);
        }

        private Node delete(int x, Node node) {
            if (node == null) {
                return null;
            }

            if (node.value == x) {
                if (node.left == null && node.right == null) {
                    node = null;
                } else if (node.right == null) {
                    node = node.left;
                } else if (node.left == null) {
                    node = node.right;
                } else {
                    int min = min(node.right);
                    node.right = delete(min, node.right);
                    node.value = min;
                }
            } else if (node.value > x) {
                node.left = delete(x, node.left);
            } else {
                node.right = delete(x, node.right);
            }
            if (node != null) {
                node.height();
                node = balance(node);
            }
            return node;
        }

        public Node balance(Node node) {
            if (node.balanceFactor() == -2) {
                if (node.left != null && node.left.balanceFactor() == 1)
                    node.left = rightRotation(node.right);
                node = leftRotation(node);
            } else if (node.balanceFactor() == 2) {
                if (node.right != null && node.right.balanceFactor() == -1)
                    node.right = leftRotation(node.right);
                node = rightRotation(node);
            }
            return node;
        }

        public Node rightRotation(Node node) {
            Node left = node.left;
            node.left = left.right;
            left.right = node;
            if (node == root) {
                root = left;
            } else {
                node = left;
            }
            left.height();
            node.height();
            return left;
        }

        public Node leftRotation(Node node) {

            Node right = node.right;
            node.right = right.left;
            right.left = node;
            if (node == root) {
                root = right;
            } else {
                node = right;
            }
            right.height();
            node.height();
            return right;
        }

        public int upperBound(int x) {
            int res = root.value;
            Node curr = root;
            while (curr != null) {
                if (curr.value > x) {
                    res = curr.value;
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            if (res < x)
                return -1;
            return res;
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
            private int value;
            private int priority;
            int height;

            public Node(int value, int priority) {
                this.value = value;
                this.priority = priority;
            }

            private int height() {
                height = height(this);
                return height;
            }

            private int height(Node node) {
                if (node == null) {
                    return -1;
                }
                return 1 + Math.max(height(node.left), height(node.right));
            }

            public int balanceFactor() {

                return height(left) - height(right);
            }

            @Override
            public String toString() {
                return (left != null ? left + " " : "") + value + (right != null ? " " + right : "");
            }

        }
    }

}

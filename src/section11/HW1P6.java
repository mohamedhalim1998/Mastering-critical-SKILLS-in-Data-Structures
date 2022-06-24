package section11;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class HW1P6 {

    public static class AVLDictionary {
        private Node root;

        public void insert(String e) {
            for (int i = 1; i < e.length() - 1; i++) {
                if (root == null) {
                    root = new Node(e, false);
                } else {
                    insert(e.substring(0, i), false, root);
                }
            }
            if (root == null) {
                root = new Node(e, true);
            } else {
                insert(e, true, root);
            }
        }

        private Node insert(String e, boolean full, Node node) {
            if (node == null) {
                return new Node(e, full);
            }
            if (e.compareTo(node.value) > 0) {
                node.right = insert(e, full, node.right);
            } else if (e.compareTo(node.value) < 0) {
                node.left = insert(e, full, node.left);
            }
            return balance(node);
        }

        public String min() {
            if (root == null) {
                return null;
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

        public boolean searchWord(String e) {
            if (root == null) {
                return false;
            }
            Node node = search(root, e);
            return node != null && node.isFullWord;
        }

        public boolean searchPrefix(String e) {
            if (root == null) {
                return false;
            }
            Node node = search(root, e);
            return node != null && node.isFullWord;
        }


        private Node search(Node node, String e) {
            if (node == null) {
                return null;
            }
            if (Objects.equals(node.value, e)) {
                return node;
            } else if (e.compareTo(node.value) < 0) {
                return search(node.left, e);
            } else {
                return search(node.right, e);
            }
        }

        private String min(Node right) {
            if (right == null) {
                return null;
            }
            Node curr = right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr.value;

        }

        public void delete(String x) {
            delete(x, root);
        }

        private Node delete(String x, Node node) {
            if (node == null) {
                return null;
            }

            if (Objects.equals(node.value, x)) {
                if (node.left == null && node.right == null) {
                    node = null;
                } else if (node.right == null) {
                    node = node.left;
                } else if (node.left == null) {
                    node = node.right;
                } else {
                    String min = min(node.right);
                    node.right = delete(min, node.right);
                    node.value = min;
                }
            } else if (x.compareTo(node.value) < 0) {
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

        public class Node {
            public Node left, right;
            private String value;
            int height;
            private boolean isFullWord;


            public Node(String value, boolean isFullWord) {
                this.value = value;
                this.isFullWord = isFullWord;
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

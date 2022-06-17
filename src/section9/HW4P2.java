package section9;

import java.util.LinkedList;
import java.util.Queue;


public class HW4P2 {

    public static class BinarySearchTree {
        private Node root;

        public BinarySearchTree(int i) {
            insert(i);
        }

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
            } else if (parent.value < e) {
                parent.right = new Node(e);
            }
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

        public int max() {
            return max(root);
        }

        private int max(Node node) {
            if (node == null) {
                return -1;
            }
            Node curr = node;
            while (curr.right != null) {
                curr = curr.right;
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


        public void delete(int x) {
            Node parent = root;
            Node curr = root;
            while (curr != null && curr.value != x) {
                parent = curr;
                if (curr.value > x) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            if (curr == null)
                return;
            if (curr.left == null && curr.right == null) {
                if (parent.left != null && parent.left.value == curr.value) {
                    parent.left = null;
                }
                if (parent.right != null && parent.right.value == curr.value) {
                    parent.right = null;
                }
            } else if (curr.right == null) {
                parent.left = curr.left;
            } else if (curr.left == null) {
                parent.right = curr.right;
            } else {
                Node toDelete = curr;
                parent = curr;
                curr = curr.right;
                while (curr.left != null) {
                    parent = curr;
                    curr = curr.left;
                }
                if (parent.right == curr) {
                    parent.right = null;
                } else {
                    parent.left = null;
                }
                toDelete.value = curr.value;
            }


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

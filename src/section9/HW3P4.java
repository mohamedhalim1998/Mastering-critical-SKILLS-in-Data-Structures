package section9;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class HW3P4 {

    public static class BinarySearchTree {
        private Node root;

        public BinarySearchTree(int i) {
            insert(i);
        }

        public BinarySearchTree() {

        }

        public BinarySearchTree(Deque<Integer> preorder) {
            Queue<Node> queue = new LinkedList<>();
            root = new Node(preorder.remove());
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Node node = queue.remove();
                    if (!preorder.isEmpty() && preorder.peek() < node.value) {
                        Node n = new Node(preorder.remove());
                        queue.add(n);
                        node.left = n;
                    }
                    if (!preorder.isEmpty() && preorder.peek() > node.value) {
                        Node n = new Node(preorder.remove());
                        queue.add(n);
                        node.right = n;
                    }
                }
            }
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
            delete(x, root, root);
        }

        private void delete(int x, Node parent, Node node) {
            if (node == null) {
                return;
            }

            if (node.value == x) {
                if (parent.left != null && parent.left.value == node.value) {
                    parent.left = node.left;
                    if (node.left != null) {
                        parent.left.right = node.right;
                    }
                } else {
                    parent.right = node.right;
                    if (node.right != null) {
                        parent.right.left = node.left;
                    }
                }
            } else {
                delete(x, node, node.left);
                delete(x, node, node.right);
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

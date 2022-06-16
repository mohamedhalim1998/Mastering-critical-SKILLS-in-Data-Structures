package section9;

import java.util.LinkedList;
import java.util.Queue;


public class HW2P1 {

    public static class BinarySearchTree {
        private Node root;

        public BinarySearchTree(int i) {
            insert(i);
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
                Node node = new Node(e);
                node.parent = parent;
                parent.left = node;
            } else if (parent.value < e) {
                Node node = new Node(e);
                node.parent = parent;
                parent.right = node;
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

        public int inorderSuccessor(int x) {
            return inorderSuccessor(x, root);
        }

        private int inorderSuccessor(int x, Node node) {
            if (node.value == x) {
                if (node.right != null) {
                    return min(node.right);
                } else {
                    while (node.parent != null && node.parent.right == node) {
                        node = node.parent;
                    }
                    if (node.parent != null) {
                        return node.parent.value;
                    } else {
                        return -1;
                    }
                }
            }
            if (node.value > x) {
                return inorderSuccessor(x, node.left);
            } else {
                return inorderSuccessor(x, node.right);
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
            public Node left, right, parent;
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

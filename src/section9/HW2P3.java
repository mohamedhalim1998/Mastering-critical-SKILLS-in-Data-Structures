package section9;

import section8.HW1P2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class HW2P3 {

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


        public boolean isDegenerate2(ArrayList<Integer> list) {
            int min = 1;
            int max = 1000;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < min || list.get(i) > max)
                    return false;
                if (list.get(i) > list.get(i - 1)) {
                    min = list.get(i) + 1;
                } else {
                    max = list.get(i) - 1;
                }
            }
            return true;
        }

        public boolean isDegenerate(ArrayList<Integer> list) {
            Stack<Node> stack = new Stack<>();
            root = new Node(list.get(0));
            stack.push(root);
            int index = 1;
            while (index < list.size()) {
                Node curr = stack.peek();
                Node node = new Node(list.get(index));

                if (curr.value > list.get(index)) {
                    curr.left = node;
                    stack.push(node);
                    index++;
                    continue;
                }
                while (stack.peek().value < list.get(index)) {
                    curr = stack.pop();
                }
                curr.right = node;
                stack.push(node);
                index++;
            }
            return height() == list.size() - 1;
        }

        private int heightHelper(Node node) {
            if (node == null) {
                return 0;
            }
            return 1 + Math.max(heightHelper(node.left), heightHelper(node.right));
        }

        public int height() {
            return heightHelper(root) - 1;
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

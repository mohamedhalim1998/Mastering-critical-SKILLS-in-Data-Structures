package section9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HW1P2 {
    public static class BinarySearchTree {
        private Node root;

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

        public void print() {
            System.out.println(this);
        }

        public boolean isBST2() {
            ArrayList<Integer> list = new ArrayList<>();
            isBST2(root, list);
            for (int i = 0; i < list.size() - 1; i++) {
                if(list.get(i) > list.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }

        private void isBST2(Node node, ArrayList<Integer> list) {
            if(node == null)
                return;
            isBST2(node.left, list);
            list.add(node.value);
            isBST2(node.right, list);

        }

        public boolean isBST() {
            return isBST(root);
        }

        private boolean isBST(Node node) {
            if (node == null) {
                return true;
            }
            if (node.left != null) {
                if (node.left.value > node.value) {
                    return false;
                }
            }
            if (node.right != null) {
                if (node.right.value < node.value) {
                    return false;
                }
            }
            return isBST(node.left) && isBST(node.right);
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

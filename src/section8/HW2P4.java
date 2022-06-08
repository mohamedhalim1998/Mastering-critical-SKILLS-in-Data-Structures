package section8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HW2P4 {
    public static class BinaryTree {
        private Node root;

        public BinaryTree(int root) {
            this.root = new Node(root);
        }

        public void print() {
            System.out.println(this);
        }

        public void addWithDirections(int[] values, char[] directions) {
            Node curr = root;
            for (int i = 0; i < values.length; i++) {
                if (directions[i] == 'L') {
                    if (curr.left == null) {
                        curr.left = new Node(values[i]);
                    } else {
                        if (curr.left.value != values[i]) {
                            throw new RuntimeException("directions not matched");
                        }
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new Node(values[i]);
                    } else {
                        if (curr.right.value != values[i]) {
                            throw new RuntimeException("directions not matched");
                        }
                    }
                    curr = curr.right;
                }
            }
        }

        private int heightHelper(Node node) {
            if (node == null) {
                return 0;
            }
            return 1 + Math.max(heightHelper(node.left), heightHelper(node.right));
        }

        public int diameter() {
            return diameterHelper(root);
        }

        private int diameterHelper(Node node) {
            if(node == null)
                return -1;
            return Math.max(heightHelper(node.left) + heightHelper(node.right),
                    Math.max(diameterHelper(node.right), diameterHelper(node.left)));
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

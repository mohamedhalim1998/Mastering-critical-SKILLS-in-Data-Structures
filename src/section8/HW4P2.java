

package section8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HW4P2 {

    public static class BinaryTree {
        private Node root;

        public BinaryTree(int root) {
            this.root = new Node(root);
        }

        public BinaryTree(Queue<Pair> preorder) {
            root = createFullTree(preorder);


        }

        private Node createFullTree(Queue<Pair> preorder) {
            Pair p = preorder.remove();
            Node node = new Node(p.first);
            if (p.second == 0) {
                if (!preorder.isEmpty()) {
                    node.left = createFullTree(preorder);
                }
                if (!preorder.isEmpty()) {
                    node.right = createFullTree(preorder);
                }
            }
            return node;
        }

        public void print() {
            System.out.println(this);
        }

        public void printPreorder() {
            System.out.println(root.preOrder().replace("null ", ""));
        }

        public void printPostorder() {
            System.out.println(root.postOrder().replace("null ", ""));
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


            public String preOrder() {
                return value + " " + (left != null ? left.preOrder() + "" : "") + (right != null ? right.preOrder() : "");
            }

            public String postOrder() {
                return left.postOrder() + " " + right.postOrder() + " " + value + " ";
            }
        }


    }

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

    }
}

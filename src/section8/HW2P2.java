package section8;

import java.util.Stack;

public class HW2P2 {
    public static class BinaryTree {
        private Node root;

        public BinaryTree(int root) {
            this.root = new Node(root);
        }

        public void print() {
            System.out.println(this);
        }

        public void printIterative() {

            Stack<Pair> stack = new Stack<>();
            stack.push(new Pair(root, false));
            while (!stack.isEmpty()) {
                Pair curr = stack.pop();
                if (curr.node == null) {
                    continue;
                }
                if(curr.print) {
                    System.out.print(curr.node.value + " ");
                    continue;
                }
                stack.push(new Pair(curr.node.right, false));
                stack.push(new Pair(curr.node, true));
                stack.push(new Pair(curr.node.left, false));
            }
            System.out.println();
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

                return(left != null ? left+ " " : "") + value + " " + (right != null ? right.toString() : "");
            }
        }

        static class Pair {
            Node node;
            boolean print;

            public Pair(Node node, boolean print) {
                this.node = node;
                this.print = print;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "node=" + node.value +
                        ", print=" + print +
                        '}';
            }
        }


    }

}

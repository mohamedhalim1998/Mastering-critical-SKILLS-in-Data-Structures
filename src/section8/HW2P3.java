package section8;

public class HW2P3 {
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

        public int traverseLeftBoundary() {
            StringBuilder out = new StringBuilder();

            Node curr = root;
            int res = curr.value;
            while (curr != null) {
                res = curr.value;
                out.append(res).append(' ');
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            System.out.println(out);
            return res;
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

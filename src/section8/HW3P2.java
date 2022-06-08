package section8;


public class HW3P1 {

    public static class BinaryTree {
        private Node root;

        public BinaryTree(int root) {
            this.root = new Node(root);
        }

        public void print() {
            System.out.println(this.toString().replace("null ", ""));
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

        private int levelHelper(Node node) {
            if (node == null) {
                return 0;
            }
            return 1 + Math.max(levelHelper(node.left), levelHelper(node.right));
        }

        public int levels() {
            return levelHelper(root);
        }

        public void printByLevelRecursive() {
            int levels = levels();
            for (int i = 0; i < levels; i++) {
                System.out.print("level " + i + ": ");
                printByLevelHelper(root, 0, i);
                System.out.println();
            }
        }

        private void printByLevelHelper(Node node, int level, int print) {
            if(node == null){
                return;
            }
            if(print == level){
                System.out.print(node.value + " ");
            }
            printByLevelHelper(node.left, level +1 , print);
            printByLevelHelper(node.right, level +1 , print);

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
                return value + " " + left + " " + right + " ";
            }

            public String postOrder() {
                return left + " " + right + " " + value + " ";
            }
        }


    }

}

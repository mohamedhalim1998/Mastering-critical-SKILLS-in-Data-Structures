package section8;

public class HW1P6 {
    public static class BinaryTree {
        private Node root;

        public BinaryTree(int root) {
            this.root = new Node(root);
        }

        public void print() {
            System.out.println(this.toString().replaceAll(" +", " ").replace("null ", ""));
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

        private boolean hasTwoChildes(Node node) {
//            if (node == null) {
//                return false;
//            }
            if (node.left == null && node.right == null) {
                return true;
            }
            if (node.left != null && node.right != null) {
                return hasTwoChildes(node.left) && hasTwoChildes(node.right);
            }
            return false;

        }

        private int height(Node node) {
            if (node == null) {
                return 0;
            }
            return 1 + Math.max(height(node.left), height(node.right));
        }


        public boolean isPerfect() {
            return height(root.left) == height(root.right) && hasTwoChildes(root);
        }
        private int countHelper(Node node) {
            if (node == null) {
                return 0;
            }
            return 1 + countHelper(node.left) + countHelper(node.right);
        }
        public int countNodes() {
            return countHelper(root);
        }
        public boolean isPerfectFormula() {
            return Math.pow(2, height(root))-1 == countNodes() ;
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
                return left + " " + value + " " + right + " ";
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

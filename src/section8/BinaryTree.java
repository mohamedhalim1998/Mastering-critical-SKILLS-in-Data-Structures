package section8;

public class BinaryTree {
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

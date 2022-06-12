
package section8;

public class HW5P2 {

    public static class BinaryTree {
        private Node root;

        public BinaryTree(int root) {
            this.root = new Node(root);
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

        public void parenthesize() {
            System.out.println(root.parenthesize());
        }

        public void parenthesizeRight() {
            System.out.println(root.parenthesizeRight());
        }

        public void add(int[] values, char[] directions) {
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


        public boolean isFlipEquivalent(BinaryTree other) {
            return isFlipEquivalentHelper(root, other.root);
        }

        private boolean isFlipEquivalentHelper(Node n1, Node n2) {
            if (n1 == null && n2 == null) {
                return true;
            }
            if (n1 == null) {
                return false;
            }
            if (n2 == null) {
                return false;
            }
            return n1.value == n2.value &&
                    ((isFlipEquivalentHelper(n1.left, n2.left) && isFlipEquivalentHelper(n1.right, n2.right)) ||
                            (isFlipEquivalentHelper(n1.left, n2.right) && isFlipEquivalentHelper(n1.right, n2.left)));
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

            public String parenthesize() {
                return "(" + value + (left != null ? left.parenthesize() : "()") + (right != null ? right.parenthesize() : "()") + ")";
            }

            public String parenthesizeRight() {
                return "(" + value + (right != null ? right.parenthesizeRight() : "()") + (left != null ? left.parenthesizeRight() : "()") + ")";
            }
        }


    }

}

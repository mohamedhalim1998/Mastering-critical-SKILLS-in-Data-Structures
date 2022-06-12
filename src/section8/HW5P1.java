
package section8;

public class HW5P1 {

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


        public boolean isMirror() {

            return isMirrorHelper(root.left, root.right);
        }

        private boolean isMirrorHelper(Node left, Node right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null) {
                return false;
            }
            if (right == null) {
                return false;
            }
            return left.value == right.value && isMirrorHelper(left.left, right.right) && isMirrorHelper(left.right, right.left);
        }

        public boolean isMirrorParenthesize() {
            if (root.left == null && root.right == null) {
                return true;
            }
            if (root.left == null) {
                return false;
            }
            if (root.right == null) {
                return false;
            }
            return root.left.parenthesize().equals(root.right.parenthesizeRight());
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
                return "(" + value + (right != null ? right.parenthesizeRight() : "()")  + (left != null ? left.parenthesizeRight() : "()") + ")";
            }
        }


    }

}


package section8;

import java.util.ArrayList;

public class HW5P3 {

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


        public void printDuplicatedSubtrees() {
            ArrayList<String> list = new ArrayList<>();
            printDuplicatedSubtreesHelper(root ,list);
            for (int i = 0; i < list.size(); i++) {
                for (int j = i+1; j < list.size(); j++) {
                    if(list.get(i).equals(list.get(j)))
                        System.out.println(list.get(i));
                }
            }
        }
        public void printDuplicatedSubtreesHelper(Node node, ArrayList<String> list) {
            if(node == null || (node.left == null && node.right == null))
                return;
            list.add(node.parenthesize());
            printDuplicatedSubtreesHelper(node.left, list);
            printDuplicatedSubtreesHelper(node.right, list);
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

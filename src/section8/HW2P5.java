package section8;

import java.util.Stack;

public class HW2P5 {
    public static class BinaryTree {
        private Node root;


        public BinaryTree(String postfix) {
            Stack<Node> stack = new Stack<>();
            for (char c : postfix.toCharArray()) {
                Node node = new Node(c);
                if (!Character.isDigit(c)) {
                    Node n1 = stack.pop();
                    Node n2 = stack.pop();
                    node.left = n2;
                    node.right = n1;
                    root = node;
                }
                stack.push(node);
            }
        }

        public void print() {
            System.out.println(this);
        }

        public void printPostorder() {
            System.out.println(root.postOrder().replace("null ", ""));
        }


        @Override
        public String toString() {
            return root.toString();
        }

        public static class Node {
            public Node left, right;
            private final char value;

            public Node(char value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return (left != null ? left + " " : "") + value + (right != null ? " " + right : "");
            }

            public String postOrder() {
                return (left != null ? left.postOrder() + "" : "") + (right != null ? "" + right.postOrder() : "") + value + "";
            }
        }


    }

}

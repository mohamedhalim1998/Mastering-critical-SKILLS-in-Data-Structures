
package section8;

import java.util.LinkedList;
import java.util.Queue;

public class HW4P1 {

    public static class BinaryTree {
        private Node root;

        public BinaryTree(int root) {
            this.root = new Node(root);
        }

        public BinaryTree(Queue<Integer> preorder, Queue<Integer> inorder) {
            root = createFromPreorderAndInorder(preorder, inorder);
        }

        private Node createFromPreorderAndInorder(Queue<Integer> preorder, Queue<Integer> inorder) {
            Node node = new Node(preorder.remove());
            if (preorder.size() == 0) {
                return node;
            }
            Queue<Integer> leftPreorder = new LinkedList<>();
            Queue<Integer> leftInorder = new LinkedList<>();
            Queue<Integer> rightPreorder = new LinkedList<>();
            Queue<Integer> rightInorder = new LinkedList<>();
            while (!inorder.isEmpty() && inorder.peek() != node.value) {
                leftInorder.add(inorder.remove());
            }
            inorder.remove();
            while (!inorder.isEmpty()) {
                rightInorder.add(inorder.remove());
            }
            int size = leftInorder.size();
            while (size-- > 0) {
                leftPreorder.add(preorder.remove());
            }
            while (!preorder.isEmpty()) {
                rightPreorder.add(preorder.remove());
            }
            if(leftInorder.size() > 0)
            node.left = createFromPreorderAndInorder(leftPreorder, leftInorder);
            if(rightInorder.size() > 0)
            node.right = createFromPreorderAndInorder(rightPreorder, rightInorder);
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
                return value + " " +  (left != null ? left.preOrder() + "" : "")  +(right != null ? right.preOrder() : "");
            }

            public String postOrder() {
                return left.postOrder() + " " + right.postOrder() + " " + value + " ";
            }
        }


    }

}

package section8;

import java.util.LinkedList;
import java.util.Queue;

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

    public void printByLevel() {
        int level = 0;
        StringBuilder out = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            out.append("level ").append(level).append(": ");
            while (size-- > 0) {
                Node node = queue.remove();

                out.append(node.value).append(' ');
                if(node.left != null)
                queue.add(node.left);
                if(node.right != null)
                queue.add(node.right);
            }
            out.append('\n');
            level++;
        }
        System.out.println(out);
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

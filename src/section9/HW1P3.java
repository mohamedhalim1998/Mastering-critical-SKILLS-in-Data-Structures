package section9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HW1P3 {
    public static class BinarySearchTree {
        private Node root;

        public BinarySearchTree() {

        }

        public BinarySearchTree(ArrayList<Integer> list) {
            insert(list, 0, list.size()-1);
        }

        private void insert(ArrayList<Integer> list, int l, int r) {
            if(l > r){
                return;
            }
            int mid = l + (r - l) / 2;
            insert(list.get(mid));
            insert(list, l, mid - 1);
            insert(list, mid + 1, r);
        }

        public void insert(int e) {
            if (root == null) {
                root = new Node(e);
                return;
            }
            Node parent = null;
            Node curr = root;
            while (curr != null) {
                parent = curr;
                if (curr.value > e) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            if (parent.value > e) {
                parent.left = new Node(e);
            } else {
                parent.right = new Node(e);
            }
        }

        public void print() {
            System.out.println(this);
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
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
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

        }

    }

}

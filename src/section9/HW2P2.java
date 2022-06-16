package section9;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;


public class HW2P2 {

    public static class BinarySearchTree {
        private Node root;

        public BinarySearchTree(int i) {
            insert(i);
        }   public BinarySearchTree() {
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
            } else if (parent.value < e) {
                parent.right = new Node(e);
            }
        }

        public int min() {
            if (root == null) {
                return -1;
            }
            Node curr = root;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr.value;
        }

        public void print() {
            System.out.println(this);
        }

        public boolean search(int e) {
            if (root == null) {
                return false;
            }
            return search(root, e);
        }

        private boolean search(Node node, int e) {
            if (node == null) {
                return false;
            }
            if (node.value == e) {
                return true;
            } else if (node.value > e) {
                return search(node.left, e);
            } else {
                return search(node.right, e);
            }
        }

        public LinkedList<Integer> successor(LinkedList<Integer> list) {
            LinkedList<Integer> res = new LinkedList<>();
            Stack<Pair> stack = new Stack<>();
            stack.push(new Pair(root, false));
            int index = 0;
            while (index < list.size() && !stack.isEmpty()) {
                Pair curr = stack.pop();
                if (curr.node == null) {
                    continue;
                }
                if (curr.done) {
                    System.out.println(curr.node.value);
                    if (list.get(index) < curr.node.value) {
                        res.add(curr.node.value);
                        index++;
                    }
                    continue;
                }
                stack.push(new Pair(curr.node.right, false));
                stack.push(new Pair(curr.node, true));
                stack.push(new Pair(curr.node.left, false));
            }
            System.out.println(stack.size());
            return res;
        }

        public LinkedList<Integer> successor2(LinkedList<Integer> list) {
            LinkedList<Integer> res = new LinkedList<>();
            successorHelper(list, res, new LinkedList<>(), root);
            return res;
        }

        public void successorHelper(LinkedList<Integer> list, LinkedList<Integer> ans, LinkedList<Integer> traversal, Node node) {
            if (node == null || list.isEmpty())
                return;
            successorHelper(list, ans, traversal, node.left);
            if (list.isEmpty())
                return;
            if (Objects.equals(list.peek(), traversal.peekLast())) {
                list.remove();
                ans.add(node.value);
            }
            traversal.add(node.value);
            if (list.isEmpty())
                return;
            successorHelper(list, ans, traversal, node.right);
        }


        private int min(Node right) {
            if (right == null) {
                return -1;
            }
            Node curr = right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr.value;

        }

        public void delete(int x) {
            delete(x, root, root);
        }

        private void delete(int x, Node parent, Node node) {
            if (node == null) {
                return;
            }

            if (node.value == x) {
                if (parent.left != null && parent.left.value == node.value) {
                    parent.left = node.left;
                    if (node.left != null) {
                        parent.left.right = node.right;
                    }
                } else {
                    parent.right = node.right;
                    if (node.right != null) {
                        parent.right.left = node.left;
                    }
                }
            } else {
                delete(x, node, node.left);
                delete(x, node, node.right);
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

        static class Pair {
            Node node;
            boolean done;

            public Pair(Node node, boolean done) {
                this.node = node;
                this.done = done;
            }

            @Override
            public String toString() {
                return "Pair{" +
                        "node=" + node.value +
                        ", print=" + done +
                        '}';
            }
        }


    }


}

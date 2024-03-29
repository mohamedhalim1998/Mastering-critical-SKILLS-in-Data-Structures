package section10;


import java.util.PriorityQueue;

public class HW2P3 {

    public static class BinarySearchTree {
        private Node root;

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

        public int inorderSuccessor(int x) {
            return inorderSuccessor(x, root, root);
        }

        private int inorderSuccessor(int x, Node parent, Node child) {
            if (parent != null && child.value == x) {
                if (child.right == null) {
                    return parent.value;
                } else {
                    return min(child.right);
                }
            }
            if (child.value > x) {
                return inorderSuccessor(x, child, child.left);
            } else {
                return inorderSuccessor(x, parent, child.right);
            }
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
                if (node.left == null && node.right == null) {
                    if (parent.left != null && parent.left.value == node.value) {
                        parent.left = null;
                    }
                    if (parent.right != null && parent.right.value == node.value) {
                        parent.right = null;
                    }
                } else if (node.right == null) {
                    parent.left = node.left;
                } else if (node.left == null) {
                    parent.right = node.right;
                } else {
                    int min = min(node.right);
                    delete(min, node.right, node.right);
                    node.value = min;
                }
            } else {
                delete(x, node, node.left);
                delete(x, node, node.right);
            }
        }

        public void printByLevel() {
            int level = 0;
            StringBuilder out = new StringBuilder();
            PriorityQueue<Node> queue = new PriorityQueue<>();
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

        public static class Node implements Comparable<Node> {
            public Node left, right;
            private int value;

            public Node(int value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return (left != null ? left + " " : "") + value + (right != null ? " " + right : "");
            }

            @Override
            public int compareTo(Node o) {
                return Integer.compare(o.value, value);
            }
        }

    }

}

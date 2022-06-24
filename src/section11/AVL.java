package section11;


import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    private Node root;

    public void insert(int e) {
        if (root == null) {
            root = new Node(e);
            return;
        }
        insert(e, root);
    }

    private Node insert(int e, Node node) {
        if (node == null) {
            return new Node(e);
        }
        if (e > node.value) {
            node.right = insert(e, node.right);
        } else if (e < node.value) {
            node.left = insert(e, node.left);
        }
        return balance(node);

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
        delete(x, root);
    }

    private Node delete(int x, Node node) {
        if (node == null) {
            return null;
        }

        if (node.value == x) {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                int min = min(node.right);
                node.right = delete(min, node.right);
                node.value = min;
            }
        } else if (node.value > x) {
            node.left = delete(x, node.left);
        } else {
            node.right = delete(x, node.right);
        }
        if (node != null) {
            node.height();
            node = balance(node);
        }
        return node;
    }

    public Node balance(Node node) {
        if (node.balanceFactor() == -2) {
            if (node.left != null && node.left.balanceFactor() == 1)
                node.left = rightRotation(node.right);
            node = leftRotation(node);
        } else if (node.balanceFactor() == 2) {
            if (node.right != null && node.right.balanceFactor() == -1)
                node.right = leftRotation(node.right);
            node = rightRotation(node);
        }
        return node;
    }

    public Node rightRotation(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        if (node == root) {
            root = left;
        } else {
            node = left;
        }
        left.height();
        node.height();
        return left;
    }

    public Node leftRotation(Node node) {

        Node right = node.right;
        node.right = right.left;
        right.left = node;
        if (node == root) {
            root = right;
        } else {
            node = right;
        }
        right.height();
        node.height();
        return right;
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
        private int value;
        int height;

        public Node(int value) {
            this.value = value;
        }

        private int height() {
            height = height(this);
            return height;
        }

        private int height(Node node) {
            if (node == null) {
                return -1;
            }
            return 1 + Math.max(height(node.left), height(node.right));
        }

        public int balanceFactor() {

            return height(left) - height(right);
        }

        @Override
        public String toString() {
            return (left != null ? left + " " : "") + value + (right != null ? " " + right : "");
        }

    }
}

package section11;

import java.util.LinkedList;
import java.util.Queue;

public class HW1P7 {

    public static class AVL {
        private int value;
        private AVL left;
        private AVL right;
        private int height;

        public AVL(int i) {
            value = i;
        }

        public void insert(int e) {
            insert(e, this);
        }

        private AVL insert(int e, AVL node) {
            if (node == null) {
                return new AVL(e);
            }
            if (e > node.value) {
                node.right = insert(e, node.right);
            } else if (e < node.value) {
                node.left = insert(e, node.left);
            }
            return balance(node);
        }

        public int min() {
            AVL curr = this;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr.value;
        }

        public void print() {
            System.out.println(this);
        }

        public boolean search(int e) {

            return search(this, e);
        }

        private boolean search(AVL node, int e) {
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

        private int min(AVL right) {
            if (right == null) {
                return -1;
            }
            AVL curr = right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr.value;

        }

        public void delete(int x) {
            delete(x, this);
        }

        private AVL delete(int x, AVL node) {
            if (node == null) {
                return null;
            }

            if (node.value == x) {
                if (node == this) {
                    deleteRoot();
                } else if (node.left == null && node.right == null) {
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

        private void deleteRoot() {
            if (this.right == null) {
                this.value = this.left.value;
                this.left = this.left.left;
                this.right = this.left.right;
            } else if (this.left == null) {
                this.value = this.right.value;
                this.left = this.right.left;
                this.right = this.right.right;
            } else {
                int min = min(this.right);
                this.right = delete(min, this.right);
                this.value = min;
            }
//            balance(this);
        }

        private int height() {
            height = height(this);
            return height;
        }

        private int height(AVL node) {
            if (node == null) {
                return -1;
            }
            return 1 + Math.max(height(node.left), height(node.right));
        }


        public int balanceFactor() {

            int res = height(left) - height(right);
            return res;
        }

        public AVL balance(AVL node) {
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

        public AVL rightRotation(AVL node) {
            AVL left = node.left;

            if (node != this) {
                node.left = left.right;
                left.right = node;
                node = left;
            } else {
                int temp = this.value;
                this.value = left.value;
                left.value = temp;
                this.left = left.left;
                left.left = left.right;
                left.right = this.right;
                this.right = left;
            }
            left.height();
            node.height();
            return left;
        }

        public AVL leftRotation(AVL node) {

            AVL right = node.right;
            if (node != this) {
                node.right = right.left;
                right.left = node;
                node = right;
            } else {
                int temp = this.value;
                this.value = right.value;
                right.value = temp;
                this.right = right.right;
                right.right = right.left;
                right.left = this.left;
                this.left = right;
            }
            right.height();
            node.height();
            return right;
        }


        public void printByLevel() {
            int level = 0;
            StringBuilder out = new StringBuilder();
            Queue<AVL> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                int size = queue.size();
                out.append("level ").append(level).append(": ");
                while (size-- > 0) {
                    AVL node = queue.remove();

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
            return (left != null ? left + " " : "") + value + (right != null ? " " + right : "");
        }
    }

}

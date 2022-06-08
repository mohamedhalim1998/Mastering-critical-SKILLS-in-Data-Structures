

import section8.*;

import javax.swing.tree.TreeNode;

public class Main {
    public static void main(String[] args) {
        HW2P4.BinaryTree tree = new HW2P4.BinaryTree(1);

        System.out.println(tree.diameter());

        tree.addWithDirections(new int[]{2 },new char[]{'L' });
        tree.addWithDirections(new int[]{3 },new char[]{'R' });

        System.out.println(tree.diameter());

        tree.addWithDirections(new int[]{2, 4, 7 },new char[]{'L', 'L', 'L' });
        tree.addWithDirections(new int[]{2, 4, 8 },new char[]{'L', 'L', 'R' });
        tree.addWithDirections(new int[]{2, 5, 9 },new char[]{'L', 'R', 'R' });
        tree.addWithDirections(new int[]{3, 6, 15 },new char[]{'R', 'R', 'L' });

        tree.addWithDirections(new int[]{2, 5, 13 },new char[]{'L', 'R', 'L' });
        tree.addWithDirections(new int[]{3, 6, 12 },new char[]{'R', 'R', 'R' });
        tree.addWithDirections(new int[]{3, 14, 15 },new char[]{'R', 'L', 'L' });
        tree.addWithDirections(new int[]{3, 14, 16 },new char[]{'R', 'L', 'R' });

        System.out.println(tree.diameter());
    }
}


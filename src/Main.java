

import section8.*;

public class Main {
    public static void main(String[] args) {
        HW1P6.BinaryTree tree = new HW1P6.BinaryTree(1);
        tree.addWithDirections(new int[]{2, 4, 7}, new char[]{'L', 'L', 'L'});
        tree.addWithDirections(new int[]{2, 4, 8}, new char[]{'L', 'L', 'R'});
        tree.addWithDirections(new int[]{2, 5, 9}, new char[]{'L', 'R', 'R'});
        tree.addWithDirections(new int[]{2, 5, 11}, new char[]{'L', 'R', 'L'});
        tree.addWithDirections(new int[]{3, 10, 12}, new char[]{'R', 'L', 'L'});
        tree.addWithDirections(new int[]{3, 10, 13}, new char[]{'R', 'L', 'R'});
        tree.addWithDirections(new int[]{3, 6, 14}, new char[]{'R', 'R', 'L'});
        tree.addWithDirections(new int[]{3, 6, 15}, new char[]{'R', 'R', 'R'});
        tree.print();
        System.out.println(tree.isPerfectFormula());

    }

}

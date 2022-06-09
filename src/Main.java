

import section8.*;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static section8.HW4P2.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Pair>  list = new LinkedList<>();
        list.add(new Pair(1, 0));
        list.add(new Pair(2, 0));
        list.add(new Pair(4, 1));
        list.add(new Pair(5, 1));
        list.add(new Pair(3, 0));
        list.add(new Pair(6, 1));
        list.add(new Pair(7, 0));
        list.add(new Pair(8, 1));
        list.add(new Pair(9, 1));
        HW4P2.BinaryTree tree = new HW4P2.BinaryTree(list);
        tree.print();
        tree.printPreorder();
    }
}


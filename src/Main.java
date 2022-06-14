import section9.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        HW1P5.BinarySearchTree bts = new HW1P5.BinarySearchTree();
        bts.insert(50);
        bts.insert(20);
        bts.insert(60);
        bts.insert(58);
        bts.insert(70);
        bts.insert(73);
        bts.insert(75);
        bts.insert(15);
        bts.insert(45);
        bts.insert(35);
        bts.insert(36);
        bts.printByLevel();
        System.out.println(bts.lca(15,45));
        System.out.println(bts.lca(45,36));
        System.out.println(bts.lca(15,70));
        System.out.println(bts.lca(58,70));
        System.out.println(bts.lca(36,75));


    }
}


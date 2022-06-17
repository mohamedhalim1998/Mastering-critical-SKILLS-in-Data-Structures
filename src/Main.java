import section9.*;

import java.util.ArrayList;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(50);
        list.add(20);
        list.add(60);
        list.add(15);
        list.add(45);
        list.add(70);
        list.add(35);
        list.add(73);
        HW3P4.BinarySearchTree bts = new HW3P4.BinarySearchTree(list);
        bts.print();
        bts.printByLevel();



    }
}


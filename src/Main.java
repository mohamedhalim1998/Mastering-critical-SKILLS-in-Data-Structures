import section9.*;

import java.util.ArrayList;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        HW2P2.BinarySearchTree bts = new HW2P2.BinarySearchTree();
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
        LinkedList<Integer> list = new LinkedList<>();
        list.add(15);
        list.add(20);
        list.add(35);
        list.add(45);
        list.add(70);
        bts.print();
        System.out.println(list);
        System.out.println(bts.successor2(list));


    }
}


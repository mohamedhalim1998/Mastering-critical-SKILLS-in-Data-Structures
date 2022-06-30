import section13.HW2P4;

import java.util.LinkedList;

import static section13.HW2P1.uniqueSubstring;
import static section13.HW2P3.anagramSubstring;

public class Main {
    public static void main(String[] args) {
        HW2P4.SinglyLinkedList lst = new HW2P4.SinglyLinkedList();
        lst.createCycle();
        lst.removeCycle();
        System.out.println(lst);
    }
}




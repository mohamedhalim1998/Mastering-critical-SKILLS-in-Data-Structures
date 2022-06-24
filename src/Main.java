
import section11.*;



public class Main {
    public static void main(String[] args) {
        HW1P7.AVL avl = new HW1P7.AVL(1);
        for (int i = 2; i <= 20; i++) {
            avl.insert(i);
            avl.print();
            avl.printByLevel();
        }
//        for (int i = 1; i <= 15; i++) {
//            avl.delete(i);
//            avl.print();
//            avl.printByLevel();
//        }
        avl.delete(8);
        avl.print();
        avl.printByLevel();


    }
}




public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
//        list.insertSorted(10);
//        list.insertSorted(2);
//        list.insertSorted(30);
//        list.insertSorted(4);
//        list.insertSorted(1);
        System.out.println(list);
        list.reverseInPlace();
        System.out.println(list);




    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(20);
        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(3);
        list.insert(1);
        list.insert(6);
        list.insert(7);
        list.insert(1);
        list.insert(5);
        list.insert(1);
//        list.insert(1);
//        list.insertSorted(10);
//        list.insertSorted(2);
//        list.insertSorted(30);
//        list.insertSorted(4);
//        list.insertSorted(1);
        //  System.out.println(list.size);
        System.out.println(list);
        list.removeLastOccurrence(50);
        System.out.println(list);


    }
}

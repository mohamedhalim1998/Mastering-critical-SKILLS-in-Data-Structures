public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
//        list.insert(1);
//        list.insert(2);
//        list.insert(2);
//        list.insert(3);
//        list.insert(2);
//        list.insert(2);
//        list.insert(1);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);
//        list.insert(11);
        System.out.println(list);
        list.swapForwardBackwardWithoutSize(2);
        System.out.println(list);
//        System.out.println(list.getMiddle());
//        list.swapForwardBackward(1);
//        list.reverse();
//        System.out.println(list);
//        list.deleteEnd();
//        System.out.println(list);
//        list.deleteFront();
//        System.out.println(list);

    }
}

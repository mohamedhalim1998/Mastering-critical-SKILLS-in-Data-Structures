public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
//        SinglyLinkedList list2 = new SinglyLinkedList();
        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(1);
        list.insert(2);
        list.insert(2);
        list.insert(3);
        list.insert(4);
//        list.insert(3);
        list.insert(5);
        list.insert(6);
        System.out.println(list);
//        list.reverseChains(3);
//        list.reverseInPlace();
        list.removeRepeatedSorted();
        System.out.println(list);

//  //      list2.insert(8);
//        list1.insert(9);
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println(list1.addNumber(list2));


    }
}

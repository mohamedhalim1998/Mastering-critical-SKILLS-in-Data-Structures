public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insertFront(3);
        list.insertFront(2);
        list.insertFront(1);
        System.out.println(list);
        list.deleteFront();
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.getFromBack(0));
        System.out.println(list.getFromBack(1));

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);
        list2.insert(5);
        list2.insert(6);
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list.equals(list2));
    }
}

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
        list.delete(2);
        System.out.println(list);



    }
}

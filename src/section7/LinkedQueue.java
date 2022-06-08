package section7;

import section3.SinglyLinkedList;

public class LinkedQueue {
    SinglyLinkedList linkedList;
    public LinkedQueue() {
        linkedList = new SinglyLinkedList();
    }

    public void enqueue(int element) {
      linkedList.insert(element);
    }



    public int dequeue() {
        return linkedList.deleteFront();
    }


    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}

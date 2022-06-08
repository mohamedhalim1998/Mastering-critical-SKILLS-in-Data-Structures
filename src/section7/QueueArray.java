package section7;

public class QueueArray {
    int front;
    int rear;
    int[] arr;
    int capacity;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }

    public void enqueue(int element) {
        if(isFull()) {
            throw new RuntimeException("queue is full");
        }
        arr[rear++] = element;
    }

    public boolean isFull() {
        return rear == capacity;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return arr[front++];
    }

    public boolean isEmpty() {
        return front == rear;
    }


}

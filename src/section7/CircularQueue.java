package section7;

public class CircularQueue {
    int front;
    int rear;
    int[] arr;
    int capacity;
    int size;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }
        size++;
        arr[rear++] = element;
        if (rear == capacity) {
            rear = 0;
        }
    }



    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        size--;
        int value = arr[front];
        arr[front++] = -1;
        if(front == capacity){
            front = 0;
        }
        return value;
    }
    public boolean isFull() {

        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        return arr[front];
    }

}

package section7;

import java.util.Arrays;

public class HW2P2 {
    public static class CircularQueue {
        int front;
        int rear;
        int[] arr;
        int capacity;

        public CircularQueue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity + 1];

            front = 0;
            rear = 0;
        }

        public int next(int x) {
            return (x + 1) % capacity;
        }

        public void enqueue(int element) {
            if (isFull()) {
                throw new RuntimeException("queue is full");
            }
            arr[rear] = element;
            rear = next(rear);
        }


        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            int value = arr[front];
            front = next(front);

            return value;
        }

        public boolean isFull() {
            return front == next(rear);
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public int peek() {
            return arr[front];
        }

        public void display() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            StringBuilder out = new StringBuilder();
            out.append("front: ").append(front).append("\trear: ").append(rear).append('\n');
            if (isEmpty()) {
                return out.toString();
            }

            int i = front;
            if (isFull()) {
                out.append(arr[i]).append(", ");
                i = next(i);
            }
            for (; i != rear; i = next(i)) {
                out.append(arr[i]).append(", ");

            }
            return out.toString();
        }
    }

}

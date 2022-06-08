package section7;

import java.util.Arrays;

public class HW1P1 {
    public static class DoubleQueue {
        int front;
        int rear;
        int[] arr;
        int capacity;
        int size;

        public DoubleQueue(int capacity) {
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

        public void enqueueFront(int element) {
            if (isFull()) {
                throw new RuntimeException("queue is full");
            }
            size++;
            if (front == 0) {
                front = capacity;
            }
            arr[--front] = element;
        }


        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            size--;
            int value = arr[front];
            arr[front++] = -1;
            return value;
        }

        public int dequeueEnd() {
            if (isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            size--;
            if (rear == 0) {
                rear = capacity;
            }
            int value = arr[--rear];
            arr[rear] = -1;
            return value;
        }

        public boolean isFull() {

            return size == capacity;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void display() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            StringBuilder out = new StringBuilder();
            out.append("front: ").append(front).append("\trear: ").append(rear).append('\n');
            for (int i = front; i < front + size; i++) {
                out.append(arr[i % capacity]).append(' ');
            }
            return out.toString();
        }
    }
}
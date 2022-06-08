package section7;

public class HW2P1 {
    static public class PriorityQueue {
        int front;
        int rear;
        Node[] arr;
        int capacity;
        int size;

        public PriorityQueue(int capacity) {
            this.capacity = capacity;
            arr = new Node[capacity];
            front = 0;
            rear = 0;
            size = 0;
        }

        public void enqueue(int element, int priority) {
            if (isFull()) {
                throw new RuntimeException("queue is full");
            }
            size++;
            int index = rear;
            int prev = index - 1;
            if(prev < 0) {
                prev = capacity -1;
            }
            while (index != front && priority > arr[prev].priority) {
                arr[index] = arr[index-1];
                index--;
                prev--;
                if(prev < 0) {
                    prev = capacity - 1;
                }
            }
            arr[index] = new Node(element, priority);
            rear++;
            if (rear == capacity) {
                rear = 0;
            }
        }


        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            size--;
            int value = arr[front].x;
            arr[front++] = null;
            if (front == capacity) {
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
            return arr[front].x;
        }

        public void display() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            if (isEmpty()) {
                return "0";
            }

            StringBuilder out = new StringBuilder();
            for (int i = front; i < front + size; i++) {
                out.append(arr[i % capacity]).append(", ");
            }
            return out.toString();
        }

        static class Node {
            int x;
            int priority;

            public Node(int x, int priority) {
                this.x = x;
                this.priority = priority;
            }

            @Override
            public String toString() {
                return "{" +
                        "value=" + x +
                        ", priority=" + priority +
                        '}';
            }
        }

    }

}

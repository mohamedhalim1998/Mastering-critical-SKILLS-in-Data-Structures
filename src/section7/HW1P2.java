package section7;

public class HW1P2 {
    public static class Stack {
        int size;
        int capacity;
        CircularQueue queue;

        public Stack(int capacity) {
            this.capacity = capacity;
            this.queue = new CircularQueue(capacity);
        }

        public void push(int element) {
            int i = 0;
            queue.enqueue(element);
            while (i < size) {
                queue.enqueue(queue.dequeue());
                i++;
            }
            size++;


        }

        public int pop() {
            size--;
            return queue.dequeue();
        }

        public int peek() {
            return queue.peek();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
}

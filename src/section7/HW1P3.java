package section7;

import section6.StackArray;

public class HW1P3 {
    public static class QueueTwoStacks {
        StackArray stack1;
        StackArray stack2;
        int capacity;

        public QueueTwoStacks(int capacity) {
            this.capacity = capacity;
            stack1 = new StackArray(capacity);
            stack2 = new StackArray(capacity);
        }

        public void enqueue(int element) {
            if (isFull()) {
                throw new RuntimeException("queue is full");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(element);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public boolean isFull() {
            return stack1.isFull() || stack2.isFull();
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("queue is empty");
            }

            return stack1.pop();

        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

        @Override
        public String toString() {
            return "QueueTwoStacks{" +
                    "stack1=" + stack1 +
                    ", stack2=" + stack2 +
                    '}';
        }
    }
}

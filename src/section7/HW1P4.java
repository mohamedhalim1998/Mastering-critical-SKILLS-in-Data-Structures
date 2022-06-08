package section7;

import section6.StackArray;

public class HW1P4 {
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

            stack1.push(element);

        }

        public boolean isFull() {
            return stack1.isFull() || stack2.isFull();
        }

        public int dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            int val =  stack2.pop();
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            return val;

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

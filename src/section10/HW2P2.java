package section10;

import java.util.ArrayList;

public class HW2P2 {

    public static class PriorityQueue {
        ArrayList<Node> arr;
        int size = 0;

        public PriorityQueue() {
            arr = new ArrayList<>();
        }


        public void enqueue(int x, int p) {
            try {
                arr.set(size, new Node(x, p));
            } catch (IndexOutOfBoundsException e) {
                arr.add(new Node(x, p));
            }
            size++;
            heapify(size - 1);
        }

        public int top() {
            return arr.get(0).value;
        }

        public int dequeue() {
            int res = arr.get(0).value;
            arr.set(0, arr.get(size - 1));
            heapifyDown(0);
            arr.set(--size, null);

            return res;
        }

        private void heapify(int i) {
            int p = parent(i);
            while (arr.get(p).priority < arr.get(i).priority) {
                Node temp = arr.get(p);
                arr.set(p, arr.get(i));
                arr.set(i, temp);
                i = p;
                p = parent(i);
            }
        }


        private void heapifyDown(int i) {
            int l = left(i);
            int r = right(i);
            if (l >= size)
                return;

            Node temp = arr.get(i);
            if (r < size && arr.get(r).priority > arr.get(l).priority) {
                l = r;
            }
            if (arr.get(l).priority > arr.get(i).priority) {
                arr.set(i, arr.get(l));
                arr.set(l, temp);
                i = l;
                heapifyDown(i);
            }


        }

        public int getSize() {
            return arr.size();
        }

        private int parent(int c) {
            return (c - 1) / 2;
        }

        private int left(int p) {
            return 2 * p + 1;
        }

        private int right(int p) {
            return 2 * p + 2;
        }

        @Override
        public String toString() {

            return arr.toString();
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static class Node {
        int value;
        int priority;

        public Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }

    }

}

package section10;

import java.util.Arrays;

public class HW2P1 {

    public static class MaxHeap {
        int[] arr;
        int size = 0;

        public MaxHeap(int capacity) {
            arr = new int[capacity];
        }


        public void insert(int x) {
            arr[size++] = x;
            heapify(size - 1);
        }

        public int top() {
            return arr[0];
        }

        public int pop() {
            int res = arr[0];
            arr[0] = arr[size - 1];
            heapifyDown(0);
            arr[--size] = -1;

            return res;
        }

        private void heapify(int i) {
            int p = parent(i);
            while (arr[p] < arr[i]) {
                int temp = arr[p];
                arr[p] = arr[i];
                arr[i] = temp;
                i = p;
                p = parent(i);
            }
        }


        private void heapifyDown(int i) {
            int l = left(i);
            int r = right(i);
            if (l >= size)
                return;

            int temp = arr[i];
            if (r < size && arr[r] > arr[l]) {
                l = r;
            }
            if (arr[l] > arr[i]) {
                arr[i] = arr[l];
                arr[l] = temp;
                i = l;
                heapifyDown(i);
            }


        }

        public int getSize() {
            return size;
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

            return Arrays.toString(arr);
        }
    }

    public static class SmallestProcessor {
        int k;
        private MaxHeap heap;

        public SmallestProcessor(int k) {
            this.k = k;
            heap = new MaxHeap(k);
        }

        public void next(int num) {

            if (heap.getSize() < k) {
                heap.insert(num);
            } else if(heap.top() > num) {
                heap.pop();
                heap.insert(num);
            }

            System.out.println(heap.top());

//            System.out.println(heap);

        }
    }

}

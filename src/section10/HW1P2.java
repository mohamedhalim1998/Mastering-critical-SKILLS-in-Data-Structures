package section10;

import java.util.ArrayList;
import java.util.Arrays;

public class HW1P2 {


    public static class MinHeap {
        int[] arr;
        int size = 0;

        public MinHeap(int size) {
            arr = new int[size];
        }

        public MinHeap(ArrayList<Integer> list) {
            arr = new int[list.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
            size = arr.length;

            for (int i = arr.length - 1; i >= 0; i--) {
                heapifyDown(i);
            }
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
            heapifyDown(0);
            arr[--size] = -1;

            return res;
        }

        private void heapify(int i) {
            int p = parent(i);
            while (arr[p] > arr[i]) {
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
            if(r < size && arr[r] < arr[l]) {
                l = r;
            }
            if (arr[l] < arr[i]) {
                arr[i] = arr[l];
                arr[l] = temp;
                i = l;
                heapifyDown(i);
            }

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

    public static class MaxHeap {
        MinHeap heap;

        public MaxHeap(int size) {
            heap = new MinHeap(size);
        }

        public MaxHeap(ArrayList<Integer> list) {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, -list.get(i));
            }

            heap = new MinHeap(list);

        }

        public void insert(int x) {
            heap.insert(-x);
        }

        public int top() {
            return -heap.top();
        }

        public int pop() {
            return -heap.pop();
        }

        @Override
        public String toString() {

            return heap.toString();
        }
    }

}

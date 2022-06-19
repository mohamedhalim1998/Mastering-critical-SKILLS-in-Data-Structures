import section10.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        int[] arr = {22, 5, 12, 7, 6, 2, 14, 19, 10, 17, 8, 37, 25, 30};
        HW1P5.MinHeap heap = new HW1P5.MinHeap(arr.length);
        System.out.println(heap.toString());
       heap.heapSort(arr);
//        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}


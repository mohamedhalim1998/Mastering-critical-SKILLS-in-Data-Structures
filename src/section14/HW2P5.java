package section14;

public class HW2P5 {
    public static void uniqueNumberUnsorted(int[] arr) {
        int[] freq = new int[501];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]] = i;
            if(freq[arr[i]] == 1) {
                System.out.println(arr[i]);
            }
        }

    }
}

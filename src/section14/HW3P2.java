package section14;

import java.util.stream.IntStream;

public class HW3P2 {
    public static int[] maxSubarray(int[] arr, int k) {
        int sum = 0;
        int max = 0;
        int l = 0;
        int r = k - 1;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        max = sum;
        for (int i = k; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            if (sum > max) {
                max = sum;
                l = i - k + 1;
                r = i;
            }
        }
        return IntStream.range(l, r + 1).toArray();
    }
}

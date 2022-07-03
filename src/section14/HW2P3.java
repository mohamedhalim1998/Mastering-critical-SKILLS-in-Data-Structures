package section14;

public class HW2P3 {
    public static int maxFreq(int[] arr) {
        int[] freq = new int[500 + 270 + 1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] + 500] = i;
        }
        int maxIndex = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[maxIndex] < freq[i]) {
                maxIndex = i;
            }
        }
        return maxIndex - 500;

    }
}

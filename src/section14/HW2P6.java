package section14;

public class HW2P6 {
    public static void sortNumbers(int[] arr) {
        int[] freq = new int[501];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]] = i;
            if(freq[arr[i]] == 1) {
                System.out.println(arr[i]);
            }
        }
        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                arr[index++] = i;
                freq[i]--;
            }
        }

    }
}

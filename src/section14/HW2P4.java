package section14;

public class HW2P4 {
    public static void digitFreq(int[] arr) {
        int[] freq = new int[10];
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                freq[arr[i] % 10]++;
                arr[i] = arr[i] / 10;
            }
        }
        for (int i = 0; i < freq.length; i++) {
            System.out.println(i + " " + freq[i]);
        }
    }
}

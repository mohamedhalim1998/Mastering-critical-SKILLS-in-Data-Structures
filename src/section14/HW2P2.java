package section14;

public class HW2P2 {
    public static void numberSearch(int[] arr, int[] queries) {
        int[] freq = new int[501];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]] = i;
        }
        for (int q : queries) {
            System.out.println(freq[q]);
        }
    }
}

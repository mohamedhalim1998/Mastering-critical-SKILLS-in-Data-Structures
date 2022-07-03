package section14;

import java.util.Scanner;

public class HW1P5 {
    public static int smallestPair() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, arr[i] + arr[j] + j - i);
            }
        }
        return min;
    }
}

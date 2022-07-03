package section14;

import java.util.Scanner;

public class HW1P2 {
    public static void replaceMinMax() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == min) {
                arr[i] = max;
            } else if (arr[i] == max) {
                arr[i] = min;
            }
        }
    }
}

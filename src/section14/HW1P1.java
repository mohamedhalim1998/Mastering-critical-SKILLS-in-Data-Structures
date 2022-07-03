package section14;

import java.util.Scanner;

public class HW1P1 {
    public static boolean increasingArray() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int curr = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < curr) {
                return false;
            }
            curr = arr[i];
        }
        return true;
    }
}

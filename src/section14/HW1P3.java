package section14;

import java.util.Scanner;

public class HW1P3 {
    public static void uniqueNumbersInorder() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int curr = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] != curr) {
                System.out.println(curr);
                curr = arr[i];
            }
        }
    }
}

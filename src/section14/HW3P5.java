package section14;

import java.util.HashMap;

public class HW3P5 {
    public static int longestSubarray(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int zero = 0;
            int one = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 0) {
                    zero++;
                } else {
                    one++;
                }
                if (zero == one) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static int longestSubarray2(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        int sum = arr[0];
        int max = 0;
        for (int i = 0, j = 1; j < arr.length && i < arr.length; ) {
            sum += arr[j];
            if (sum == 0) {
                max = Math.max(max, j - i + 1);
                j++;
            } else if (sum < 0) {
                sum -= arr[i];
                sum -= arr[j];
                i++;
            } else {
                j++;
            }
        }
        return max;
    }

    public static int longestSubarray3(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        int sum = arr[0];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum) );
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}

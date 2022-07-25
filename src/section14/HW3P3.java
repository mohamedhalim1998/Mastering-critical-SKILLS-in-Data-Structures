package section14;

public class HW3P3 {
    public static int increasingSubarrays(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    break;
                }
                count++;
            }
        }
        return count;
    }

    public static int increasingSubarraysOneLoop(int[] arr) {
        int count = 1;
        int sum = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            sum += count;
        }
        return sum;
    }


}

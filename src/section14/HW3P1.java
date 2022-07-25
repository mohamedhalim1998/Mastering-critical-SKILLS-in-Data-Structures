package section14;

import java.util.HashSet;

public class HW3P1 {
    public static int recamán(int index) {
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[200];
        set.add(0);
        for (int i = 1; i < 200; i++) {
            int val = arr[i - 1] - i +1 - 1;
            if (val < 0 || set.contains(val)) {
                val = arr[i - 1] + i;
            }
            arr[i] = val;
            set.add(val);
        }
        return arr[index];
    }
}

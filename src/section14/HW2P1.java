package section14;

public class HW2P1 {
    public static void minThree(int[] arr) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
        for (int x : arr) {
            if (x < a) {
                c = b;
                b = a;
                a = x;
            } else if(x < b) {
                c = b;
                b = x;
            } else if(x < c) {
                c = x;
            }
        }
        System.out.println(a + " " + b + " " + c);
    }
}

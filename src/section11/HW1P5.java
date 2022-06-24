package section11;

public class HW1P5 {
    public static int avlNodesRec(int h) {
        if (h == 0) {
            return 1;
        }
        if (h == 1) {
            return 2;
        }
        return 1 + avlNodesRec(h - 1) + avlNodesRec(h - 2);
    }

    public static int avlNodesIter(int h) {
        if (h == 0) {
            return 1;
        }
        if (h == 1) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int res = 2;
        for (int i = 2; i <= h; i++) {
            res = a + b + 1;
            a = b;
            b = res;
        }
        return res;
    }
}

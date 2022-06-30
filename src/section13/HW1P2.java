package section13;

public class HW1P2 {

    public static int hashString(String str, int n) {
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int s = 0;
            for (int j = 0; j < 4; j++, i++) {
                s = (s * 26 + str.charAt(i) - 'a') % n;
            }
            sum = (sum + s) % n;
        }
        return (int) (sum % n);
    }

}

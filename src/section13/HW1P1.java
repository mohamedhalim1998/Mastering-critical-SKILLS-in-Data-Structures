package section13;

public class HW1P1 {

    public static int hashString(String str, int n) {
        long sum = 0;
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            int s = 0;
            if (Character.isUpperCase(c)) {
                s = 26 + c - 'A';
            } else if (Character.isLowerCase(c)) {
                s = c - 'a';
            } else {
                s = 2 * 26 + c - '0';
            }
            sum = (sum + s * (2 * 26 + 10)) % n;
        }

        return (int) (sum % n);
    }
}

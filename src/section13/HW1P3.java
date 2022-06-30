package section13;

public class HW1P3 {

    public static int hashString(String str, int n) {
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum = (sum * 26 + str.charAt(i) - 'a') % n;
        }
        return (int) (sum % n);
    }

    static class A {
        String str1, str2;
        int value;
        int n = Integer.MAX_VALUE;

        public int hash() {
            return ((hashString(str1, n) + hashString(str2, n)) % n + value) % n;
        }
    }

}

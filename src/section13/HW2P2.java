package section13;

import java.util.HashSet;

public class HW2P2 {
    public static int commonSubstring(String s1, String s2) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i + 1; j <= s1.length(); j++) {
                set.add(s1.substring(i, j));
            }
        }
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            for (int j = i + 1; j <= s2.length(); j++) {
                String sub = s2.substring(i, j);
                if (set.contains(sub)) {
                    count++;
                    set.remove(sub);
                }
            }
        }
        return count;
    }
}

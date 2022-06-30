package section13;

import java.util.ArrayList;
import java.util.HashSet;

public class HW2P3 {
    public static int anagramSubstring(String s) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int k = 0; k < 26; k++) {
                    list.add(0);
                }
                for (int k = i; k < j; k++) {
                    list.set(s.charAt(k) - 'a', list.get(s.charAt(k) - 'a') + 1);
                }
                set.add(list);
            }
        }
        return set.size();
    }
}

package section12;

import java.util.TreeMap;

public class HW1P4 {

    public class Trie {
        boolean isWord;
        TreeMap<Character, Trie> children = new TreeMap<>();

        public void insert(String s) {
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                Trie trie = curr.children.getOrDefault(c, new Trie());
                curr = trie;
                curr.children.put(c, trie);
            }
            curr.isWord = true;
        }

        public boolean containsWord(String s) {
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!curr.children.containsKey(c))
                    return false;
                curr = curr.children.get(c);
            }
            return curr.isWord;
        }

        public boolean containsPrefix(String s) {
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!curr.children.containsKey(c))
                    return false;
                curr = curr.children.get(c);
            }
            return true;
        }


    }

}

package section12;

import java.util.ArrayList;
import java.util.List;

public class HW3P1 {

    public static class Trie {
        boolean isWord;
        Trie[] children = new Trie[26];


        public void insert(String s) {
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] == null)
                    curr.children[index] = new Trie();
                curr = curr.children[index];
            }
            curr.isWord = true;
        }

        public boolean containsWord(String s) {
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] == null)
                    return false;
                curr = curr.children[index];
            }
            return curr.isWord;
        }

        public boolean containsPrefix(String s) {
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] == null)
                    return false;
                curr = curr.children[index];
            }
            return true;
        }

        public boolean containsSub(String s, Trie trie) {
            int index = s.charAt(0) - 'a';
            boolean res = false;
            if (trie.children[index] != null) {
                res = trie.containsPrefix(s);
            }
            if (res)
                return true;
            for (int i = 0; i < 26; i++) {
                if (trie.children[i] != null) {
                    res = containsSub(s, trie.children[i]);
                }
            }
            return res;

        }

        public void listSubstr(String str, List<String> queries) {
            insert(str);
            for (String s : queries) {
                if (containsSub(s, this)) {
                    System.out.println(s);
                }
            }
        }

        public void listSubstr2(String str, List<String> queries) {
            for (String s : queries) {
                insert(s);
            }
            Trie curr = this;
            int s = -1;
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 'a';
                if (curr.children[index] != null) {
                    if (s == -1)
                        s = i;
                    curr = curr.children[index];
                } else {
                    if (s != -1) {
                        if (curr.isWord) {
                            System.out.println(str.substring(s, i));
                        }
                        s = -1;
                        curr = this;
                        i--;
                    }
                }
            }
        }

    }

}

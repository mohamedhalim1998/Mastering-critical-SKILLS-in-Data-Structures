package section12;

import java.util.ArrayList;
import java.util.HashSet;

public class HW3P2 {

    public class Trie {
        boolean isWord;
        int index;
        Trie[] children = new Trie[26];

        public Trie() {
        }

        public Trie(String[] words) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                insert(word, i);
            }
        }

        public void insert(String s, int a) {
            s = s + "{";
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                curr = this;
                curr.index = a;
                for (int j = i; j < 2 * s.length() - 1; j++) {
                    int index = s.charAt(j % s.length()) - 'a';
                    if (curr.children[index] == null) {
                        curr.children[index] = new Trie();
                    }

                    curr = curr.children[index];
                    curr.index = a;
                }
                curr.isWord = true;
            }
            // System.out.println(getAllWords());
        }

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

        private void getAllWords(HW2P1.Trie trie, ArrayList<String> list, String s) {
            if (trie == null)
                return;
            if (trie.isWord) {
                list.add(s);
            }
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                getAllWords(trie.children[i], list, s + c);
            }
        }


    }

}

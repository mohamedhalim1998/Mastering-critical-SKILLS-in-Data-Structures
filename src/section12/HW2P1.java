package section12;

import java.util.ArrayList;

public class HW2P1 {

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

        public ArrayList<String> getAllWords() {
            ArrayList<String> list = new ArrayList<>();
            getAllWords(this, list, "");
            return list;
        }

        private void getAllWords(Trie trie, ArrayList<String> list, String s) {
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

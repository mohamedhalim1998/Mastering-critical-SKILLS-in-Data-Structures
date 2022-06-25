package section12;

public class HW1P3 {

    public class Trie {
        boolean isWord;
        Trie[] children = new Trie[26];

        public void insert(String s) {
            Trie curr = this;
            for (int i = s.length()-1; i >= 0; i--) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] == null)
                    curr.children[index] = new Trie();
                curr = curr.children[index];
            }
            curr.isWord = true;
        }

        public boolean containsSuffix(String s) {
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (curr.children[index] == null)
                    return false;
                curr = curr.children[index];
            }
            return true;
        }


    }

}

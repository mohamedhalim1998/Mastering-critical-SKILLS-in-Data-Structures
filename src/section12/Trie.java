package section12;

public class Trie {
    boolean isWord;
    Trie[] children = new Trie[26];

    public void insert(String s) {
        insert(s, 0);
    }

    private void insert(String s, int i) {
        if (i == s.length()) {
            isWord = true;
        } else {
            int index = s.charAt(i) - 'a';
            if (children[index] == null)
                children[index] = new Trie();
            children[index].insert(s, i + 1);
        }
    }

    public boolean containsWord(String s) {
        return containsWord(s, 0);
    }

    private boolean containsWord(String s, int i) {
        if (i == s.length()) {
            return isWord;
        } else {
            int index = s.charAt(i) - 'a';
            if (children[index] == null)
                return false;
            return children[index].containsWord(s, i + 1);
        }
    }

    public boolean containsPrefix(String s) {
        return containsPrefix(s, 0);
    }

    private boolean containsPrefix(String s, int i) {
        if (i == s.length()) {
            return true;
        } else {
            int index = s.charAt(i) - 'a';
            if (children[index] == null)
                return false;
            return children[index].containsPrefix(s, i + 1);
        }
    }


}

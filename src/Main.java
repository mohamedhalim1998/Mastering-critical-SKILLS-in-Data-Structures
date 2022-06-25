
import section12.*;



public class Main {
    public static void main(String[] args) {
        HW1P2.Trie trie = new HW1P2.Trie();
        trie.insert("xyza");
        trie.insert("xyzea");
        trie.insert("testa");

        System.out.println(trie.firstWordPrefix("xyzabc"));


    }
}




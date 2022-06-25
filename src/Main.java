
import section12.*;



public class Main {
    public static void main(String[] args) {
        HW2P3.Trie trie = new HW2P3.Trie();
        trie.insert("hello");
        trie.insert("hallo");
        trie.insert("code");
        trie.insert("zella");

//        System.out.println(trie.wordExistWithChange("xello"));
        System.out.println(trie.wordExistWithChange("aaaaa"));
//        System.out.println(trie.wordExistWithChange("hexlo"));




    }
}




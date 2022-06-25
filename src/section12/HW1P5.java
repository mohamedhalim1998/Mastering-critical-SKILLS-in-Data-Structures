package section12;

import java.util.ArrayList;
import java.util.TreeMap;

public class HW1P5 {

    public class Trie {
        TreeMap<String, Trie> children = new TreeMap<>();

        public void insert(ArrayList<String> path) {
            Trie curr = this;
            for (String s : path) {
                Trie trie = curr.children.getOrDefault(s, new Trie());
                curr = trie;
                curr.children.put(s, trie);
            }
        }

        public boolean containsSubPath(ArrayList<String> path) {
            Trie curr = this;
            for (String s : path) {
                if (!curr.children.containsKey(s))
                    return false;
                curr = curr.children.get(s);
            }
            return true;
        }


    }

}

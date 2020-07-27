package Tree.Trie;

/**
 * 前缀树 208
 */
public class Trie {

    private boolean is_string = false;
    private Trie next[] = new Trie[26];

    /** Initialize your data structure here. */
    public Trie() {}

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        char w[] = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i]-'a'] == null)
                root.next[w[i]-'a'] = new Trie();

            root = root.next[w[i]-'a'];
        }
        root.is_string = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        char w[] = word.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (root.next[w[i]-'a'] == null)
                return false;
            root = root.next[w[i]-'a'];
        }
        return root.is_string;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;
        char p[] = prefix.toCharArray();
        for (int i = 0; i < p.length; i++) {
            if (root.next[p[i]-'a'] == null)
                return false;
            root = root.next[p[i]-'a'];
        }
        return true;
    }

}

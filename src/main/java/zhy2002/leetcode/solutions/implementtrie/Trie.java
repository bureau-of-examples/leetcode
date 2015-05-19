package zhy2002.leetcode.solutions.implementtrie;


/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {

    private static class TrieNode {

        public char val;
        public boolean isEnd;
        public TrieNode[] nodes;

        public TrieNode(char val) {
            this.val = val;
            isEnd = false;
            nodes = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode('^');//start
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.nodes[index] == null) {
                node.nodes[index] = new TrieNode(ch);
            }
            node = node.nodes[index];
        }
        node.isEnd = true;
    }



    // Returns if the word is in the trie.
    public boolean search(String word) {

        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.nodes[ch - 'a'];
            if (node == null)
                return false;
        }
        return node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.nodes[ch - 'a'];
            if (node == null)
                return false;
        }
        return true;
    }


}

package zhy2002.leetcode.solutions.addandsearchword;

/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * For example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 * [[Category: Data Structure/Trie]]
 */
public class WordDictionary {

    private static class TrieNode {

        public TrieNode(char ch) {
            this.ch = ch;
        }

        public char ch;
        public TrieNode[] children = new TrieNode[26];
        public boolean isTerminal = false; //a word ends here
    }

    private TrieNode root = new TrieNode('_');

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(ch);
            }
            node = node.children[index];
        }
        node.isTerminal = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word.length() == 0)
            return root.isTerminal;
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        char ch = word.charAt(index);
        if (ch != '.') {
            node = node.children[ch - 'a'];
            if (node == null)
                return false;
            if (index == word.length() - 1)
                return node.isTerminal;

            return search(word, index + 1, node);
        }

        if(index == word.length() - 1) {
            for (TrieNode n : node.children) {
               if(n != null && n.isTerminal)
                   return true;
            }
        } else {
            for (TrieNode n : node.children) {
                if (n != null && search(word, index + 1, n))
                    return true;
            }
        }

        return false;
    }

}

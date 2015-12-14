package zhy2002.leetcode.solutions.wordsearchii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search-ii/
 * <p>
 * TreeSetSolution:
 * http://www.programcreek.com/2014/06/leetcode-word-search-ii-java/
 * <p>
 * Do DFS on the board, use a trie to check if the current path can match a word.
 */
public class Solution {

    //dfs state
    private Trie trie;
    private int rowCount, colCount;
    boolean[][] visiting; //if we are visiting cell i, j
    private Set<String> result;
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {

        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        rowCount = board.length;
        colCount = board[0].length;
        visiting = new boolean[rowCount][colCount];
        this.board = board;
        result = new HashSet<>();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                addWordsStartingHere(i, j, "");
            }
        }

        return new ArrayList<>(result);
    }

    private void addWordsStartingHere(int i, int j, String pathString) {
        if (i < 0 || i >= rowCount || j < 0 || j >= colCount || visiting[i][j])
            return;

        pathString += board[i][j];
        if (!trie.startWith(pathString))
            return; //no word can be found from this state

        if(trie.search(pathString)){
            result.add(pathString);
        }

        visiting[i][j] = true;
        addWordsStartingHere(i + 1, j, pathString);
        addWordsStartingHere(i, j + 1, pathString);
        addWordsStartingHere(i - 1, j, pathString);
        addWordsStartingHere(i, j - 1, pathString);
        visiting[i][j] = false;

    }

    //tested in oj
    public static class Trie {

        private final TrieNode root = new TrieNode();
        private boolean empty = true;

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a'; //all chars are lower case alphabet
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.hasWord = true;
            if (empty)
                empty = false;
        }

        public boolean startWith(String prefix) {
            if (prefix.length() == 0)
                return !empty;
            return search(prefix, true);
        }

        public boolean search(String word) {
            return search(word, false);
        }

        private boolean search(String word, boolean prefixOk) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null)
                    return false;
                node = node.children[index];
            }
            return prefixOk || node.hasWord;
        }

        private static class TrieNode {
            private TrieNode[] children = new TrieNode[26];
            private boolean hasWord = false;
        }

    }
}

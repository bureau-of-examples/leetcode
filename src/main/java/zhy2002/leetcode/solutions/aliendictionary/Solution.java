package zhy2002.leetcode.solutions.aliendictionary;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 * For example,
 * Given the following words in dictionary,
 * <p>
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * The correct order is: "wertf".
 * <p>
 * Note:
 * You may assume all letters are in lowercase.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 */
public class Solution {

    private static class Node {
        public char value;
        List<Node> predecessors = new LinkedList<>();

        Node(char value) {
            this.value = value;
        }
    }

    public String alienOrder(String[] words) {

        Node[] nodes = new Node[26];
        int maxWordLength = getMaxWordLength(words);
        buildDAG(words, maxWordLength, nodes);

        StringBuilder sortedChars = new StringBuilder();
        dfs(sortedChars, nodes);
        return sortedChars.toString();

    }

    private void dfs(StringBuilder sortedChars, Node[] nodes) {
        char[] flags = new char[26];
        for (Node startNode : nodes) {
            try {
                if (startNode != null)
                    dfs(sortedChars, startNode, flags);
            } catch (RuntimeException ex) {
                sortedChars.setLength(0);
                return;
            }
        }
    }

    private void dfs(StringBuilder sortedChars, Node node, char[] accessFlag) {
        if (accessFlag[node.value - 'a'] == 'd')
            return; //visited

        if (accessFlag[node.value - 'a'] == 'v') { //if visiting
            throw new RuntimeException("cycle detected");
        }

        accessFlag[node.value - 'a'] = 'v';
        for (Node predecessor : node.predecessors) {
            dfs(sortedChars, predecessor, accessFlag);
        }

        sortedChars.append(node.value);
        accessFlag[node.value - 'a'] = 'd';
    }

    private void buildDAG(String[] words, int maxWordLength, Node[] nodes) {
        for (int index = 0; index < maxWordLength; index++) {
            char previousChar = 0;
            String previousWord = null;
            for (String word : words) {
                if (index < word.length()) {
                    char currentChar = word.charAt(index);
                    if (nodes[currentChar - 'a'] == null) {
                        nodes[currentChar - 'a'] = new Node(currentChar);
                    }
                    if (previousChar != 0 && previousChar != currentChar) {
                        if (index == 0 || index < previousWord.length() && previousWord.charAt(index - 1) == word.charAt(index - 1)) {
                            nodes[currentChar - 'a'].predecessors.add(nodes[previousChar - 'a']);
                        }

                    }
                    previousChar = currentChar;
                }
                previousWord = word;
            }
        }
    }

    private int getMaxWordLength(String[] words) {
        int maxWordLength = 0;
        for (String word : words) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        return maxWordLength;
    }
}

package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class MagicDictionaryTests {

    class MagicDictionary {

        private class TrieNode {
            TrieNode[] children = new TrieNode[26];
            String word;
        }

        private TrieNode root = new TrieNode();

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
        }

        /**
         * Build a dictionary through a list of words
         */
        public void buildDict(String[] dict) {
            for (String str : dict) {
                addToTrie(str);
            }
        }

        private void addToTrie(String str) {
            TrieNode node = root;
            for (char ch : str.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = str;
        }

        /**
         * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
         */
        public boolean search(String word) {
            return search(root, word);
        }

        private boolean match(TrieNode start, String word, int charIndex) {
            for (int i = charIndex; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (start.children[index] == null)
                    return false;
                start = start.children[index];
            }
            return start.word != null;
        }

        private boolean search(TrieNode start, String word) {
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                for (int j = 0; j < 26; j++) {
                    if (start.children[j] == null || j == index)
                        continue;

                    if (match(start.children[j], word, i + 1)) {
                        return true;
                    }
                }
                if (start.children[index] == null)
                    return false;
                start = start.children[index];
            }

            return false; //all matched, never corrected
        }
    }

    @Test
    public void test() {
        MagicDictionary dictionary = new MagicDictionary();
        dictionary.buildDict(new String[]{"hello", "leetcode"});
        assertThat(dictionary.search("hhllo"), equalTo(true));
        assertThat(dictionary.search("hello"), equalTo(false));
        assertThat(dictionary.search("hell"), equalTo(false));
        assertThat(dictionary.search("leetcoded"), equalTo(false));
    }

}

package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.wordsearchii.Solution;

import java.util.List;

import static org.junit.Assert.*;


public class WordSearchIITests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        char[][] board = Utils.stringToCharMatrix("ab cd");
        List<String> result = solution.findWords(board, new String[]{"ef", "bc", "abd", "abc"});
        assertEquals(1, result.size());

        board = Utils.stringToCharMatrix("abc def");
        result = solution.findWords(board, new String[]{"bce", "bcd", "feb", "feba"});
        assertEquals(2, result.size());

        board = Utils.stringToCharMatrix("abaabb bbabab");
        result = solution.findWords(board, new String[]{"bce", "bcd", "feb", "feba", "bbaabb"});
        assertEquals(1, result.size());

        board = Utils.stringToCharMatrix("abaabb bbaacb bbbaad");
        result = solution.findWords(board, new String[]{"bce", "bcd", "aaaaacc", "aaaaaaa", "aaaa"});
        assertEquals(1, result.size());

        board = Utils.stringToCharMatrix("abaabb bbaacb bbbaad ddaccb");
        result = solution.findWords(board, new String[]{"bce", "bbbcd", "aaab", "aadeeacd", "def", "ccabaac", "bccacc"});
        assertEquals(2, result.size());
    }

    @Test
    public void emptyTrieTest(){
        Solution.Trie trie = new Solution.Trie();
        assertFalse(trie.startWith(""));
        assertFalse(trie.search(""));

        trie.insert("");
        assertTrue(trie.startWith(""));
        assertTrue(trie.search(""));

        trie = new Solution.Trie();
        trie.insert("abc");
        assertTrue(trie.startWith(""));
        assertFalse(trie.search(""));

        trie.insert("");
        assertTrue(trie.search(""));
    }

    @Test
    public void basicTrieTest(){
        Solution.Trie trie = new Solution.Trie();
        trie.insert("abc");
        trie.insert("abd");

        assertTrue(trie.startWith("ab"));
        assertTrue(trie.search("abc"));
        assertFalse(trie.search("aes"));
        assertFalse(trie.search("abdf"));

        trie = new Solution.Trie();
        trie.insert("abc");
        assertTrue(trie.search("abc"));
        assertFalse(trie.search("ab"));
        trie.insert("ab");
        assertTrue(trie.search("ab"));
        trie.insert("ab");
        assertTrue(trie.search("ab"));
    }
}

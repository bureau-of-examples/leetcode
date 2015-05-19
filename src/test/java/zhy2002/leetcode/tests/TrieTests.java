package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.implementtrie.Trie;
import static org.junit.Assert.*;

public class TrieTests {

    @Test
    public void emptyTest(){
        Trie trie = new Trie();
        assertFalse(trie.startsWith(""));
        assertFalse(trie.search(""));

        trie.insert("");
        assertTrue(trie.startsWith(""));
        assertTrue(trie.search(""));

        trie = new Trie();
        trie.insert("abc");
        assertTrue(trie.startsWith(""));
        assertFalse(trie.search(""));

        trie.insert("");
        assertTrue(trie.search(""));
    }

    @Test
    public void basicTest(){
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abd");

        assertTrue(trie.startsWith("ab"));
        assertTrue(trie.search("abc"));
        assertFalse(trie.search("aes"));
        assertFalse(trie.search("abdf"));

        trie = new Trie();
        trie.insert("abc");
        assertTrue(trie.search("abc"));
        assertFalse(trie.search("ab"));
        trie.insert("ab");
        assertTrue(trie.search("ab"));
        trie.insert("ab");
        assertTrue(trie.search("ab"));
    }
}

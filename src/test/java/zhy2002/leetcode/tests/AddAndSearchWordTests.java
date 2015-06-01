package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.addandsearchword.WordDictionary;

import static org.junit.Assert.*;

public class AddAndSearchWordTests {

    @Test
    public void basicTest() {
        WordDictionary dictionary = new WordDictionary();
        assertEquals(false, dictionary.search(""));

        dictionary.addWord("a");
        assertEquals(true, dictionary.search("."));
        assertEquals(true, dictionary.search("a"));
        assertEquals(false, dictionary.search(".."));

        dictionary.addWord("bc");
        assertEquals(true, dictionary.search("b."));
        assertEquals(true, dictionary.search(".c"));

        dictionary.addWord("abc");
        assertEquals(true, dictionary.search(".b."));
        assertEquals(true, dictionary.search("a.c"));

        dictionary.addWord("xbefd");
        assertEquals(false, dictionary.search("xbe.c"));

    }

    @Test
    public void failedTest() {
        WordDictionary dictionary = new WordDictionary();

        dictionary.addWord("ran");
        dictionary.addWord("rune");
        dictionary.addWord("runner");
        dictionary.addWord("runs");
        dictionary.addWord("add");
        dictionary.addWord("adds");
        dictionary.addWord("adder");
        dictionary.addWord("addee");
        assertEquals(true, dictionary.search("r.n"));
        assertEquals(false, dictionary.search("ru.n.e"));
        assertEquals(true, dictionary.search("add"));
        assertEquals(true, dictionary.search("add."));
        assertEquals(true, dictionary.search("adde."));
        assertEquals(false, dictionary.search(".an."));
        assertEquals(true, dictionary.search("...s"));
        assertEquals(true, dictionary.search("....e."));
        assertEquals(false, dictionary.search("......."));
        assertEquals(false, dictionary.search("..n.r"));
    }
}

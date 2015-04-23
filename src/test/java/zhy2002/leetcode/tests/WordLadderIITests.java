package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.wordladderii.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class WordLadderIITests {

    @Test
    public void basicTests(){
        Solution solution = new Solution();
        Set<String> dict = new HashSet<>();
        dict.add("bad");
        List<List<String>> result = solution.findLadders("bad", "bad", dict);
        assertEquals("[[bad]]", Utils.listOfListToString(result));

        dict.add("bat");
        result = solution.findLadders("bad", "bat", dict);
        assertEquals("[[bad,bat]]", Utils.listOfListToString(result));

        dict.add("sat");
        result = solution.findLadders("bad", "sat", dict);
        assertEquals("[[bad,bat,sat]]", Utils.listOfListToString(result));

        dict.clear();
        dict.add("bat");
        dict.add("bad");
        dict.add("but");
        dict.add("bud");
        dict.add("buy");
        dict.add("say");
        result = solution.findLadders("bat", "bud", dict);
        assertEquals("[[bat,but,bud],[bat,bad,bud]]", Utils.listOfListToString(result));

        dict.clear();
        dict.add("bat");
        dict.add("bad");
        dict.add("but");
        dict.add("bud");
        dict.add("buy");
        dict.add("say");
        dict.add("tud");
        result = solution.findLadders("bat", "tud", dict);
        assertEquals("[[bat,but,bud,tud],[bat,bad,bud,tud]]", Utils.listOfListToString(result));

        dict.clear();
        dict.add("bat");
        dict.add("bad");
        dict.add("but");
        dict.add("bud");
        dict.add("buy");
        dict.add("say");
        dict.add("tud");
        result = solution.findLadders("bat", "tud", dict);
        assertEquals("[[bat,but,bud,tud],[bat,bad,bud,tud]]", Utils.listOfListToString(result));

        dict.clear();
        dict.addAll(Arrays.asList("ts", "sc", "ph", "ca", "jr", "hf", "to", "if", "ha", "is", "io", "cf", "ta"));
        result = solution.findLadders("ta", "if", dict);
        assertEquals("[[ta,ca,cf,if],[ta,to,io,if],[ta,ts,is,if],[ta,ha,hf,if]]", Utils.listOfListToString(result));
    }
}

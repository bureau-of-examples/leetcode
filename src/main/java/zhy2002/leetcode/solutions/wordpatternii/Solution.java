package zhy2002.leetcode.solutions.wordpatternii;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * <p>
 * Examples:
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 */
public class Solution {

    public boolean wordPatternMatch(String pattern, String str) {
        return match(pattern, 0, str, 0, new String[26]);
    }

    private boolean match(String pattern, int pIndex, String str, int sIndex, String[] mapped) {
        if (pIndex < pattern.length()) {
            if (sIndex < str.length()) {
                int pCharValue = pattern.charAt(pIndex) - 'a';
                if (mapped[pCharValue] == null) {
                    for (int end = sIndex + 1; end <= str.length(); end++) {
                        String m = str.substring(sIndex, end);
                        if(contains(mapped, m))
                            continue;
                        mapped[pCharValue] = m;
                        if (match(pattern, pIndex + 1, str, sIndex + end - sIndex, mapped))
                            return true;
                    }
                    mapped[pCharValue] = null;
                    return false;
                } else {
                    String m = mapped[pCharValue];
                    return str.regionMatches(sIndex, m, 0, m.length()) && match(pattern, pIndex + 1, str, sIndex + m.length(), mapped);
                }
            } else {
                return false;
            }
        } else {
            return sIndex >= str.length();
        }
    }

    private boolean contains(String[] mapped, String m) {
        for(String s : mapped) {
            if(s != null && s.equals(m))
                return true;
        }
        return false;
    }
}

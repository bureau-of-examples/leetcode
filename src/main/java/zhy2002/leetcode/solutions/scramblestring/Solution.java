package zhy2002.leetcode.solutions.scramblestring;


import java.util.HashMap;

/**
 * https://leetcode.com/problems/scramble-string/
 */
public class Solution {

    private static class Quadruple {
        private int val1, val2, val3, val4;

        public Quadruple(int val1, int val2, int val3, int val4) {
            this.val1 = val1;
            this.val2 = val2;
            this.val3 = val3;
            this.val4 = val4;
        }

        @Override
        public int hashCode() {
            int result = val1;
            result = 37 * result + val2;
            result = 37 * result + val3;
            result = 37 * result + val4;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Quadruple) {
                Quadruple other = (Quadruple) obj;
                return val1 == other.val1 && val2 == other.val2 && val3 == other.val3 && val4 == other.val4;
            }
            return false;
        }
    }

    private HashMap<Quadruple, Boolean> cache;

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        if (s1.length() == 0)
            return true;
        cache = new HashMap<>();
        return isScramble(s1, 0, s1.length(), s2, 0, s2.length());
    }

    private boolean isScramble(String s1, int start1, int end1, String s2, int start2, int end2) {
        //end1 - start1 === end2 - start2
        if (start1 == end1 - 1)
            return s1.charAt(start1) == s2.charAt(start2);

        Quadruple quad = new Quadruple(start1, end1, start2, end2);
        Boolean result = cache.get(quad);
        if (result != null)
            return result;

        result = Boolean.FALSE;
        int count = end1 - start1;
        for (int i = 1; i < count; i++) {
            if (isScramble(s1, start1, start1 + i, s2, start2, start2 + i) && isScramble(s1, start1 + i, end1, s2, start2 + i, end2)
                    || isScramble(s1, start1, start1 + i, s2, end2 - i, end2) && isScramble(s1, start1 + i, end1, s2, start2, end2 - i)) {
                result = Boolean.TRUE;
                break;
            }
        }

        cache.put(quad, result);
        return result;

    }

}

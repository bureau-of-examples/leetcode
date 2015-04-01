package zhy2002.leetcode.solutions.longestvalidparentheses;

/**
 * Fast solution found on the internet. Can't remember the original url though.
 */
public class CountingSolution implements Solution {

    @Override
    public int longestValidParentheses(String s) {
        int length = 0;
        int score = 0;
        int start = 0;
        int cur = 0;
        int bound;

        while (cur < s.length()) {//this will get the longest if count of ( <= count of }
            score += (s.charAt(cur) == '(') ? 1 : -1;

            if (score == 0) {
                length = Math.max(length, cur - start + 1);
            } else if (score < 0) {
                start = cur + 1;
                score = 0;
            }

            ++cur;
        }

        if (score > 0) {
            bound = start - 1;
            cur = s.length() - 1;
            start = cur;
            score = 0;

            while (cur > bound) {//do it from the other end to catch the missing cases
                score += (s.charAt(cur) == ')') ? 1 : -1;

                if (score == 0) {
                    length = Math.max(length, start - cur + 1);
                } else if (score < 0) {
                    start = cur - 1;
                    score = 0;
                }

                --cur;
            }
        }

        return length;
    }
}

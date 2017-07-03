package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class ConvertANumberToHexadecimalTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.toHex(-1), equalTo("ffffffff"));
    }

    public class Solution {
        public String toHex(int num) {
            char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            int MASK = 15;
            Stack<Character> characterStack = new Stack<>();
            while (num != 0) {
                int digit = num & MASK;
                characterStack.push(digits[digit]);
                num >>>= 4;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!characterStack.isEmpty()) {
                stringBuilder.append(characterStack.pop());
            }
            return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
        }
    }

}

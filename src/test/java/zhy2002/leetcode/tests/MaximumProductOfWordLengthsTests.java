package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/discuss/
 */
public class MaximumProductOfWordLengthsTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int maxProduct(String[] words) {
            int[] charFlag = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int flag = 0;
                for (char ch : word.toCharArray()) {
                    flag |= 1 << (ch - '0');
                }
                charFlag[i] = flag;
            }
            int maxProd = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if ((charFlag[i] & charFlag[j]) == 0) {
                        int prod = words[i].length() * words[j].length();
                        maxProd = Math.max(maxProd, prod);
                    }
                }
            }
            return maxProd;
        }
    }
}

package zhy2002.leetcode.solutions.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * In turn calculate all possible strings for substring (0,0), (0,1), (0,2)...
 */
public class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;

        List<StringBuilder> buffer = new ArrayList<>();
        buffer.add(new StringBuilder()); //seed will grow
        int digitIndex = 0;
        while (digitIndex < digits.length()) {

            char ch = digits.charAt(digitIndex);
            int maxOffset = ch == '9' || ch == '7' ? 3 : 2;
            int lastBufferSize = buffer.size();
            for (int offset = 0; offset <= maxOffset; offset++) {
                int additionalOffset = ch >= '8' ? 1 : 0;
                char digitChar = (char) ((ch - '2') * 3 + 97 + offset + additionalOffset);
                for (int i = 0; i < lastBufferSize; i++) {
                    StringBuilder stringBuilder = buffer.get(i);

                    if (offset == 0)
                        stringBuilder.append(digitChar);
                    else {
                        stringBuilder = new StringBuilder().append(stringBuilder);
                        stringBuilder.setCharAt(stringBuilder.length() - 1, digitChar);
                        buffer.add(stringBuilder);
                    }
                }
            }
            digitIndex++;
        }

        for (StringBuilder stringBuilder : buffer) {
            result.add(stringBuilder.toString());
        }

        return result;
    }
}

package zhy2002.leetcode.solutions.textjustification;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 */
public class Solution {

    public List<String> fullJustify(String[] words, int L) {

        ArrayList<String> result = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        int start = 0, end = 0;
        boolean ended = false; //if end is beyond boundary
        int wordsLen = 0; //total length of words in the range [start, end)

        while (!ended) {
            if (end == words.length) {
                ended = true;
            }

            if (!ended && wordsLen + words[end].length() + (end - start) <= L) {
                wordsLen += words[end].length();
                end++;
            } else {
                int avgSpace = 0, extraSpace = 0;
                if (end - start > 1) {
                    avgSpace = (L - wordsLen) / (end - start - 1);
                    extraSpace = (L - wordsLen) % (end - start - 1);
                }
                for (int i = start; i < end; i++) {
                    buffer.append(words[i]);
                    //addition space
                    if (ended) { //last line
                        if (i != end - 1) {
                            buffer.append(' ');
                        } else {
                            int remainingSpace = L - wordsLen - (end - start - 1);
                            for (int j = 0; j < remainingSpace; j++) {
                                buffer.append(' ');
                            }
                        }
                    } else {
                        if (end - start == 1) {
                            for (int j = wordsLen; j < L; j++) {
                                buffer.append(' ');
                            }
                        } else if (i != end - 1) {
                            for (int j = 0; j < avgSpace; j++) {
                                buffer.append(' ');
                            }
                            if (i - start < extraSpace) {
                                buffer.append(' ');
                            }
                        }
                    }

                }
                result.add(buffer.toString());
                buffer.setLength(0);
                wordsLen = 0;
                start = end;
            }

        }

        return result;
    }

}

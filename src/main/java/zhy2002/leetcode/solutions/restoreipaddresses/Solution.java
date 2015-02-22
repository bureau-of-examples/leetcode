package zhy2002.leetcode.solutions.restoreipaddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/restore-ip-addresses/
 * backtracking.
 */
public class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<Integer> breaks = new ArrayList<>();//solution
        breaks.add(0); //sentinel; a complete set of breaks is: 0, a, b, c, len(s). A dot will be inserted before a, b, c.
        restoreIpAddresses(result, s, breaks);
        return result;
    }

    private void restoreIpAddresses(List<String> result, String s, List<Integer> breaks) {
        int lastBreak = breaks.get(breaks.size() - 1);
        if (breaks.size() == 5) {//full set of breaks then output result
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < breaks.size(); i++) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(".");
                }
                stringBuilder.append(s.substring(breaks.get(i - 1), breaks.get(i)));
            }
            result.add(stringBuilder.toString());
            return;
        }

        //make sure breaks are meaningful.
        int partIndex = breaks.size() - 1;//part index ranging from 0 to 3.
        for (int i = lastBreak; i < s.length(); i++) {
            if (partIndex == 3) {
                i = s.length() - 1;
            }

            if (s.length() - i < 3 - partIndex) {//not enough digits left
                break;
            }

            if (i - lastBreak > 2) {//part can only have at most 3 digits
                break;
            }

            if(i != lastBreak && s.charAt(lastBreak) == '0'){//0 must be a single part
                break;
            }

            if (s.length() - i > 12) {//too many digits left for the remaining parts
                continue;
            }

            if (Integer.valueOf(s.substring(lastBreak, i + 1)) > 255) //part value is too big
                break;

            breaks.add(i + 1);
            restoreIpAddresses(result, s, breaks);
            breaks.remove(breaks.size() - 1);
        }

    }
}

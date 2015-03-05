package zhy2002.leetcode.solutions.minimumwindowsubstring;

import java.util.HashMap;

/**
 * https://oj.leetcode.com/problems/minimum-window-substring/
 */
public class Solution {

    public String minWindow(String S, String T) {
        if(T.length() == 0)
            return "";

        HashMap<Character, Integer> tCharCounts = new HashMap<>();
        for(int i=0; i<T.length(); i++){
            Character ch = T.charAt(i);
            Integer count = tCharCounts.get(ch);
            if(count == null)
                tCharCounts.put(ch, 1);
            else
               tCharCounts.put(ch, count + 1);
        }

        int minStart = -1, minEnd = -1;
        int start = 0;
        int enoughCharCount = 0;
        for(int end = 0; end <S.length(); end++){
            Character ch = S.charAt(end);
            Integer count = tCharCounts.get(ch);
            if(count == null)
                continue;
            count -= 1;
            tCharCounts.put(ch, count);
            if(count == 0)
                enoughCharCount++;
            if(enoughCharCount == tCharCounts.size()){ //[start, end] has got all chars
                while (true){
                    Character startChar = S.charAt(start);
                    Integer startCharCount = tCharCounts.get(startChar);
                    if(startCharCount == null)
                        start++;
                    else if(startCharCount < 0){
                        tCharCounts.put(startChar, startCharCount + 1);
                        start++;
                    } else {
                        break;
                    }
                }

                if(minStart == -1 || end - start < minEnd - minStart){
                    minStart = start;
                    minEnd = end;
                }
            }
        }

        if(minStart == -1)
            return "";
        return S.substring(minStart, minEnd + 1);
    }
}

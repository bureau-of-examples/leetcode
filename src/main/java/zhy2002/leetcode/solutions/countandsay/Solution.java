package zhy2002.leetcode.solutions.countandsay;

/**
 * https://leetcode.com/problems/count-and-say/
 * Use two string builders - the second say the first, and the first say the second.
 */
public class Solution {

    public String countAndSay(int n) {
        //base cases
        if(n <= 0)
            return "";
        if(n == 1)
            return "1";

        StringBuilder[] builders = new StringBuilder[]{new StringBuilder("1"), new StringBuilder()};//front and back buffers
        for(int i=1; i<n; i++){
            StringBuilder from = builders[(i-1)%2];
            StringBuilder to = builders[i%2];

            to.setLength(0);
            char ch = from.charAt(0);
            int chCount = 1;
            for(int j=1; j<=from.length(); j++){
                if(j < from.length() && from.charAt(j) == ch)
                    chCount++;
                else{
                    to.append(chCount);
                    to.append(ch);
                    if(j < from.length()){
                        ch = from.charAt(j);
                        chCount = 1;
                    }
                }
            }
        }
        return builders[(n-1)%2].toString();
    }
}

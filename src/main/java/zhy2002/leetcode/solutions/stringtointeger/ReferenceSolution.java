package zhy2002.leetcode.solutions.stringtointeger;

/**
 * Reference solution from the e-book.
 */
public class ReferenceSolution implements Solution {

    private static final int maxDiv10 = Integer.MAX_VALUE / 10;

    public int atoi(String str) {
        int i = 0, len = str.length();
        while (i<len && Character.isWhitespace(str.charAt(i)))//skip whitespace
            i++;
        if(i==len)
            return 0;

        char ch = str.charAt(i);
        int sign = 1;//get sign
        if(ch == '-'){
            sign = -1;
            i++;
        }
        else if(ch == '+'){
            sign = 1;
            i++;
        }
        else if(ch < '0' || ch > '9')
            return 0;
        if(i == len)
            return 0;

        ch = str.charAt(i);
        int result = 0;
        while (ch >= '0' && ch <= '9'){
            int digit = ch - '0';
            if(result > maxDiv10 || result == maxDiv10 && digit >= 8)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + digit;
            i++;
            if(i == len)
                break;
            ch = str.charAt(i);
        }
        return sign * result;

    }
}

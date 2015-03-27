package zhy2002.leetcode.solutions.stringtointeger;

/**
 * String to integer conversion.
 * Use long to check overflow.
 */
public class LongSolution implements Solution{

    @Override
    public int atoi(String str) {
        long result = 0;
        Boolean sign = null;
        int startIndex = -1, endIndex = -2;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);//foreach char
            if(sign == null){//get sign
                if(Character.isWhitespace(ch))
                    continue;
                if(ch == '-'){
                    sign = Boolean.FALSE;
                } else if(ch == '+'){
                    sign = Boolean.TRUE;
                } else if(Character.isDigit(ch)){
                    sign = Boolean.TRUE;
                    i--;//back one
                } else {
                   return 0;//first char is invalid
                }
            } else {
                if(Character.isDigit(ch)){
                    if(startIndex == -1)
                        startIndex = i;
                    endIndex = i;
                    if(endIndex - startIndex > 9){
                        return sign  == Boolean.TRUE ? Integer.MAX_VALUE : Integer.MIN_VALUE;//check overflow
                    }
                } else {
                    break;//invalid char
                }
            }
        }

        //construct result
        long power = 1;
        for(int i=endIndex; i>= startIndex; i--){
            result += (str.charAt(i) - '0') * power;
            power *= 10;
        }
        if(sign == Boolean.FALSE) {
            result = -result;
            if(result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        } else {
            if(result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        return (int)result;
    }

}

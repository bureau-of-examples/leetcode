package zhy2002.leetcode.solutions.addbinary;

/**
 * https://leetcode.com/problems/add-binary/
 */
public class Solution {

    public String addBinary(String a, String b) {
        if(a == null || b == null)
            return null;

        int maxLen = a.length() > b.length() ? a.length() : b.length();
        char[] chars = new char[maxLen + 1];//cater for carry
        int carry = 0;
        for(int i=0; i<maxLen; i++){
            int indexA = a.length() - 1 - i;
            int indexB = b.length() - 1 - i;
            int digitA = indexA >= 0 ? a.charAt(indexA) - 48 : 0;
            int digitB = indexB >= 0 ? b.charAt(indexB) - 48 : 0;
            int result = digitA + digitB + carry;
            chars[maxLen - i] = (char)((result % 2) + 48);
            carry = result / 2;
        }
        if(carry == 1){
            chars[0] = 48 + 1;
            return new String(chars);
        } else {
            return new String(chars, 1, maxLen);
        }
    }
}

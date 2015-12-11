package zhy2002.leetcode.solutions.strobogrammaticnumberiii;

/**
 * https://leetcode.com/problems/strobogrammatic-number-iii/
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
 *
 * For example,
 * Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
 *
 * Note:
 * Because the range might be a large number, the low and high numbers are represented as string.
 */
public class Solution {

    private static final char[] CENTER_CHARS = {'0', '1', '8'};
    private static final char[] WING_CHARS = {'0', '1', '6', '8', '9'};

    //First count the total number of strobo numbers whose length is longer than low but shorter than high
    //all strobo numbers with these lengths should be counted
    //then find the count of those has the same length as low but greater or equal and
    //find the count of those has the same length as hight but less or equal
    public int strobogrammaticInRange(String low, String high) {

        int count = countAllWithLength(low.length() + 1, high.length() - 1);
        count += countBetween(low, low.length() < high.length() ? null : high );
        if(low.length() < high.length()){
            count += countBetween(null, high);
        }
        return count;
    }

    public int countBetween(String low, String high){
        if(low != null && high != null && low.length() != high.length()){
            return 0;
        }
        int strLen = low == null ? high.length() : low.length();
        char[] buffer = new char[strLen];
        int center = strLen / 2;
        int count = 0;
        if(strLen % 2 == 1){ //odd
            for(char ch : CENTER_CHARS){
                buffer[center] = ch;
                count += countBetween(center - 1, center + 1, buffer, low, high);
            }
        } else {
            count += countBetween(center-1, center, buffer, low, high);
        }
        return count;
    }

    private int countBetween(int left, int right, char[] buffer, String low, String high) {
        if(left == -1){
            String result = new String(buffer);
            if((low == null || low.compareTo(result) <= 0) && (high == null || high.compareTo(result) >= 0))
                return 1;
            return 0;
        }
        int count = 0;
        int i = left == 0 ? 1 : 0;
        for(; i<WING_CHARS.length; i++){
            buffer[left] = WING_CHARS[i];
            buffer[right] = WING_CHARS[i] == '6' ? '9' : WING_CHARS[i] == '9' ? '6' : WING_CHARS[i];
            count += countBetween(left - 1, right + 1, buffer, low, high);
        }
        return count;
    }

    public int countAllWithLength(int minLen, int maxLen){
        if(minLen > maxLen){
            return 0;
        }
        int minOdd, minEven;
        if(minLen % 2 == 0){
            minOdd = minLen + 1;
            minEven = minLen;
        } else {
            minOdd = minLen;
            minEven = minLen + 1;
        }

        int count = 0;
        //count odd
        int oddCount = 3;
        for(int i=1; i<=maxLen; i+=2){
            if(i >= minOdd){
                count += oddCount;
            }
            if(i == 1){
                oddCount *= 4;
            } else {
                oddCount *= 5;
            }
        }
        //count even
        int evenCount = 4;
        for(int i = 2; i<=maxLen; i+=2){
           if(i >= minEven){
               count += evenCount;
           }
            evenCount *= 5;
        }

        return count;
    }

}

package zhy2002.leetcode.solutions.strobogrammaticnumber;

/**
 * https://leetcode.com/problems/strobogrammatic-number/
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * rite a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class Solution {

    private static final boolean[] CAN_CONTAIN = {true, true, false, false, false, false, true, false, true, true};

    public boolean isStrobogrammatic(String num) {

        int start = -1, end = num.length();
        while (++start <= --end) {
            int valStart = num.charAt(start) - '0';
            int valEnd = num.charAt(end) - '0';
            if (!(CAN_CONTAIN[valStart] && CAN_CONTAIN[valEnd])) {
                return false;
            }
            switch (valStart){
                case 6:
                    if(valEnd != 9)
                        return false;
                    break;
                case 9:
                    if(valEnd != 6)
                        return false;
                    break;
                default:
                    if(valEnd != valStart)
                        return false;
                    break;
            }
        }
        return true;
    }
}

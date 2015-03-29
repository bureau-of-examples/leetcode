package zhy2002.leetcode.solutions.integertoroman;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class Solution {

    public String intToRoman(int num) {
        int[] levels = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM","D", "CD","C","XC","L","XL","X","IX","V","IV","I"};
        int index = 0;
        StringBuilder result = new StringBuilder();
        do{
            if(num >= levels[index]){
                result.append(romans[index]);
                num -= levels[index];
            } else {
                index++;
            }
        } while (index < levels.length);
        return result.toString();
    }
}

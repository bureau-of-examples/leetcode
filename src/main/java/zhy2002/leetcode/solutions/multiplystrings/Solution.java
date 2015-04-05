package zhy2002.leetcode.solutions.multiplystrings;

/**
 * https://leetcode.com/problems/multiply-strings/
 * Textbook multiplication.
 */
public class Solution {

    public String multiply(String num1, String num2) {

        //populate half multiplication table.
        int[] mulTable = new int[45];
        for (int i = 1; i < 10; i++)
            for (int j = 1; j <= i; j++) {
                mulTable[(i - 1) * i / 2 + j - 1] = i * j;
            }

        StringBuilder result = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                //calculate the product of num2[i] and num1[j]
                int product = 0;
                if (j >= 0 && num2.charAt(i) != '0' && num1.charAt(j) != '0') {
                    int left = num2.charAt(i) - '0';
                    int right = num1.charAt(j) - '0';
                    if (left < right) {
                        int temp = left;
                        left = right;
                        right = temp;
                    }
                    product = mulTable[(left - 1) * left / 2 + right - 1];
                }

                //set this result digit and carry
                int valIndex = num2.length() - i - 1 + num1.length() - j - 1;
                int existingValue = valIndex < result.length() ? result.charAt(valIndex) - '0' : 0;
                existingValue = product + existingValue + carry;
                carry = existingValue / 10;
                if(existingValue != 0){
                    while (valIndex >= result.length()){
                        result.append('0');
                    }
                    result.setCharAt(valIndex, (char) (existingValue % 10 + 48));
                }

            }
        }

        result.reverse();
        return result.length() == 0 ? "0" : result.toString();
    }
}

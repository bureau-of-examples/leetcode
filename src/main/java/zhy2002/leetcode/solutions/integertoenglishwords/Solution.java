package zhy2002.leetcode.solutions.integertoenglishwords;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * <p>
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class Solution {

    private static final int[] numbers = {1_000_000_000, 1_000_000, 1000, 1};
    private static final String[] words = {" Billion", " Million", " Thousand", ""};
    private static final String[] one_to_ten = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    private static final String[] eleven_to_nineteen = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] twenty_to_ninety = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        String result = "";
        for (int i = 0; i < numbers.length; i++) {
            int part = num / numbers[i];
            if (part > 0) {
                if (result.length() > 0) {
                    result += " ";
                }
                result += numberToThreeDigits(part, words[i]);
                num -= part * numbers[i];
            }
        }
        return result;
    }

    private String numberToThreeDigits(int i, String suffix) {
        String result = "";
        if (i >= 100) {
            result += one_to_ten[i / 100 - 1] + " Hundred";
        }
        if (i % 100 != 0) {
            if (result.length() > 0)
                result += " ";
            result += numberToTwoDigits(i % 100);
        }
        return result + suffix;
    }

    private String numberToTwoDigits(int i) {
        if (i <= 10)
            return one_to_ten[i - 1];
        if (i < 20)
            return eleven_to_nineteen[i - 11];
        if (i < 100) {
            int digit1 = i % 10;
            return twenty_to_ninety[i / 10 - 2] + (digit1 > 0 ? " " + one_to_ten[digit1 - 1] : "");
        }
        throw new IllegalArgumentException("i");
    }
}

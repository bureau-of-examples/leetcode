package zhy2002.leetcode.additional.numbertoenglish;

/**
 * CCI question 19.6:
 * given a number between 0 and 999,999, print how it should be read in english; e.g. One Thousand, Two Hundred and Thirty Four.
 */
public class Solution {

    private static final String[] ZERO_TO_TWENTY = {
            "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN",
            "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"
    };

    private static final String[] TWENTY_TO_NINETY = {
            "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"
    };

    public String numberToEnglish(int n) {
        return numberToEnglish(n, true);
    }

    public String numberToEnglish(int n, boolean rightMost) {
        if (n < 20)
            return ZERO_TO_TWENTY[n];
        if (n < 100) {
            int digit2 = n / 10;
            int digit1 = n % 10;
            return TWENTY_TO_NINETY[digit2 - 2] + (digit1 == 0 ? "" : " "+ ZERO_TO_TWENTY[digit1]);
        }
        if (n < 1000) {
            int digit3 = n / 100;
            int digit21 = n % 100;
            return ZERO_TO_TWENTY[digit3] + " HUNDRED" + (digit21 == 0 ? "" : (rightMost ? " AND " : " ") + numberToEnglish(digit21));
        }
        if(n < 1_000_000) {
            int digit4AndAbove = n / 1000;
            int digit321 = n % 1000;
            return numberToEnglish(digit4AndAbove, false)
                    + " THOUSAND"
                    + (digit321 == 0 ? "" : (digit321 < 100 || digit321 % 100 == 0 ?  " AND ": ", ") + numberToEnglish(digit321));
        }
        throw new IllegalArgumentException("n should be less than 1 million.");
    }
}

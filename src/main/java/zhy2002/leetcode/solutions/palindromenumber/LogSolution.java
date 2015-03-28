package zhy2002.leetcode.solutions.palindromenumber;

/**
 * Get the first digit and the last digit and compare.
 * Use log(10, x) to find out how many digits there is.
 */
public class LogSolution implements Solution{

    @Override
    public boolean isPalindrome(int x) {

        if (x == 0)
            return true;

        if (x < 0)
            return false;

        int digits = (int) Math.floor(Math.log(x) / Math.log(10) + 1);//100 has 3 digits, 101 has a little more than 3 digits..
        int lowPow = 1;
        int highPow = (int) Math.pow(10, digits - 1);

        while (lowPow < highPow) {
            int lowDigit = (x / lowPow) % 10;
            int highDigit = (x / highPow) % 10;
            if (lowDigit != highDigit)
                return false;

            lowPow *= 10;
            highPow /= 10;
        }

        return true;
    }
}

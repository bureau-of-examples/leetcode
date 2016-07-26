package zhy2002.leetcode.solutions.guessnumberhigherorlower;


public class Solution extends GuessGame {

    /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
    public int guessNumber(int n) {

        int start = 1, end = n;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            int result = guess(mid);
            if (result == 0)
                return mid;
            if (result > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}

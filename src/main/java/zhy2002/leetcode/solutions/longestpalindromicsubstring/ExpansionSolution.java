package zhy2002.leetcode.solutions.longestpalindromicsubstring;

/**
 * At each possible center, expend the left and right wings as much as possible.
 */
public class ExpansionSolution implements Solution {

    @Override
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return s;

        int leftCenter = (s.length() - 1) / 2;//left center of s
        int rightCenter = leftCenter;//left center will move left <= and right center will move right =>
        int maxCenter = leftCenter;//left center of longest palindrome substring
        int maxLen = 1;//length of longest palindrome substring
        int maxRadius = 0;//number of characters to the left of left center of the longest palindrome substring

        do {//each time we examine 4 centers, marked as 0, 1, 2, 3
            int loopStart = leftCenter >= 0 ? 0 : 2;
            int loopEnd = rightCenter < s.length() && rightCenter != leftCenter ? 3 : 1;
            boolean continueToFind = loopStart <= loopEnd;

            for (int i = loopStart; i <= loopEnd; i++) {
                int center = i < 2 ? leftCenter : rightCenter; //0, 1 examine left center
                boolean isOdd;//single center expansion or double center expansion
                if (leftCenter == rightCenter) {//the first time
                    isOdd = (s.length() % 2 + i) % 2 != 0;//length is even then even first; length is odd then odd first
                } else {
                    isOdd = i < 2 ^ i % 2 == 0;//left: even then odd; right: odd then even
                }
                int maxPossibleLen;//used to check if possible to find longer palindrome substring
                if (isOdd)
                    maxPossibleLen = (Math.min(center, s.length() - 1 - center) << 1) + 1;
                else
                    maxPossibleLen = (Math.min(center, s.length() - 1 - center - 1) << 1) + 2;

                if (maxPossibleLen <= maxLen) {
                    if (i >= 2) {
                        continueToFind = false;
                        break;
                    } else {
                        if (i == 0)
                            i++;//check if right center is still ok
                        continue;
                    }
                }

                if (!isOdd && (center + 1 == s.length() || s.charAt(center) != s.charAt(center + 1)))//check if the double center constitute a palindrome
                    continue;

                //expand
                int leftIndex = center - 1;
                int rightIndex = center + 1 + (isOdd ? 0 : 1);
                while (leftIndex >= 0 && rightIndex < s.length()) {
                    if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
                        leftIndex--;
                        rightIndex++;
                    } else {
                        break;
                    }
                }

                //check if is longer
                int radius = center - leftIndex - 1;
                int len = (radius << 1) + (isOdd ? 1 : 2);
                if (len > maxLen) {
                    maxCenter = center;
                    maxRadius = radius;
                    maxLen = len;
                }
            }

            if (!continueToFind)
                break;
            leftCenter--;
            rightCenter++;
        } while (leftCenter >= 0 || rightCenter < s.length());

        return s.substring(maxCenter - maxRadius, maxCenter - maxRadius + maxLen); //maxRadius << 1 + (maxIsOdd ? 1 : 2)
    }

}

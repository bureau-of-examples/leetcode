package zhy2002.leetcode.solutions.permutationsequence;

/**
 * https://leetcode.com/problems/permutation-sequence/submissions/
 */
public class Solution {

    public String getPermutation(int n, int k) {
        int facN = n;
        for (int i = n - 1; i > 1; i--)
            facN *= i;
        if (k > facN)
            return null;//out of range [1, facN]

        //populate buffer
        char[] buffer = new char[n];
        for (int i = 1; i <= n; i++) {
            buffer[i - 1] = (char) (i + '0');
        }

        //set digits one by one
        facN /= n;
        int sourceIndex = 0;
        while (k > 1) {
            int count = k / facN;//how many times to increase (++) this digit
            int remainder = k % facN;

            int targetIndex = sourceIndex + count;
            if (remainder == 0) {
                targetIndex--;
                remainder = facN; //refund
            }

            //move
            if (targetIndex > sourceIndex) {
                char temp = buffer[targetIndex];
                do {
                    buffer[targetIndex] = buffer[targetIndex - 1];
                    targetIndex--;
                } while (targetIndex != sourceIndex);
                buffer[sourceIndex] = temp;//increase source index to target index value
                k = remainder;
            }
            sourceIndex++;
            facN /= n - sourceIndex;
        }
        return new String(buffer);

    }
}

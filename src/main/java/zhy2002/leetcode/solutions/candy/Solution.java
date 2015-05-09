package zhy2002.leetcode.solutions.candy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/candy/
 * We can prove the correctness of this solution:
 * If we decrease the candy of any child:
 * 1) child ranking > left and right
 * 2) child ranking > left
 * 3) child ranking > right
 * 4) child ranking <= left and <= right
 */
public class Solution {

    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1); //each child must have one
        for (int i = 1; i < ratings.length; i++) {//ensure right child with higher ranking has more candy
            if (ratings[i] > ratings[i - 1] && candy[i] <= candy[i - 1])
                candy[i] = candy[i - 1] + 1;
        }

        for (int i = ratings.length - 2; i >= 0; i--) {//ensure left child with higher ranking has more candy
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1])
                candy[i] = candy[i + 1] + 1;
        }

        //sum up all candy
        int sum = 0;
        for (int count : candy) {
            sum += count;
        }
        return sum;
    }
}

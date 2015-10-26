package zhy2002.leetcode.solutions.productofarrayexceptself;

import java.util.Arrays;

/**
 * The extra array is not necessary.
 */
public class NoBufferSolution implements Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        Arrays.fill(result, 1); //multiplication identity
        for(int i=1; i<nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        int leftProduct = nums[nums.length - 1];
        for(int i=nums.length - 2; i>=0; i--){
            result[i] *= leftProduct;
            leftProduct *= nums[i];
        }

        return result;
    }
}

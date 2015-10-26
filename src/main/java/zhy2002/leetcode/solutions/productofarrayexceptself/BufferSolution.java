package zhy2002.leetcode.solutions.productofarrayexceptself;

import java.util.Arrays;

/**
 * Use two arrays a and b:
 * a[i]: product of items left of i
 * b[i]: product of items right of i
 * result[i] = a[i]*b[i]
 */
public class BufferSolution implements Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] buffer = new int[nums.length];
        Arrays.fill(buffer, 1); //multiplication identity
        for(int i=1; i<nums.length; i++){
            buffer[i] = buffer[i-1] * nums[i-1];
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for(int i=nums.length - 2; i>=0; i--){
            result[i] = result[i+1] * nums[i+1];
        }

        for(int i=0; i<nums.length; i++){
            result[i] *= buffer[i];
        }
        return result;
    }
}

package zhy2002.leetcode.solutions.singlenumber;

/**
 * x ^ x = 0
 * 0 ^ x = x
 */
public class XorSolution implements Solution  {

    @Override
    public int singleNumber(int[] A) {
        int x=0;

        for(int a: A){
            x = x ^ a;
        }

        return x;
    }
}

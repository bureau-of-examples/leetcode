package zhy2002.leetcode;

/**
 * Test util class.
 */
public final class Utils {
    private Utils(){}

    public static long factorial(byte n){
        long result = 1;
        for(long i=2; i<=n; i++){
            result *= i; //we dont care about overflow as this is testing code
        }
        return result;
    }
}

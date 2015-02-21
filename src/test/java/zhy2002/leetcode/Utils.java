package zhy2002.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static <T>  List<List<T>> arrayOfArrayToListOfList(T[][] array){
        if(array == null)
            return null;

        ArrayList<List<T>> result = new ArrayList<>();
        for(T[] item : array){
            result.add(Arrays.asList(item));
        }
        return result;

    }
}

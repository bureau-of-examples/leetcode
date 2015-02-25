package zhy2002.leetcode;

import zhy2002.leetcode.common.ListNode;

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

    public static ListNode createLinkedList(int[] items){
        ListNode head = null;
        ListNode current = null;
        for(int i : items){
            if(head == null){
                head = current = new ListNode(i);
            } else {
                current.next = new ListNode(i);
                current = current.next;
            }
        }
        return head;
    }

    public static int[] createRange(int start, int end/*exclusive*/){
        int[] result = new int[end - start];
        for(int i=start; i<end; i++){
            result[i-start] = i;
        }
        return result;
    }
}

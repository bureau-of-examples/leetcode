package zhy2002.leetcode;

import zhy2002.leetcode.common.Interval;
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

    public static String intervalsToString(Iterable<Interval> list){
        StringBuilder stringBuilder = new StringBuilder();
        if(list != null){
            stringBuilder.append("[");
            boolean first = true;
            for(Interval interval : list){
                if(first)
                    first = false;
                else
                    stringBuilder.append(",");

                stringBuilder.append("[");
                if(interval != null){
                    stringBuilder.append(interval.start);
                    stringBuilder.append(",");
                    stringBuilder.append(interval.end);
                }
                stringBuilder.append("]");
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }

    public static String integersToString(Iterable<Integer> list){
        StringBuilder stringBuilder = new StringBuilder();
        if(list != null){
            boolean first = true;
            for(Integer i : list){
                if(first)
                    first = false;
                else
                    stringBuilder.append(",");

                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }

}

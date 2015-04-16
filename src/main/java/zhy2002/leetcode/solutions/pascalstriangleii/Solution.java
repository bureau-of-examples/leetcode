package zhy2002.leetcode.solutions.pascalstriangleii;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * Circular queue, calculate row by row.
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0)
            return null;

        ArrayList<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);
        if (rowIndex == 0)
            return result;

        result.add(1);
        int startIndex = 0, endIndex = 1;
        for (int i = 2; i <= rowIndex; i++) {

            for (int j = 0; j < i - 1; j++) {
                int val1 = result.get(startIndex);
                startIndex = (startIndex + 1) % (rowIndex + 1);
                int val2 = result.get(startIndex);
                endIndex = (endIndex + 1) % (rowIndex + 1);
                if (endIndex >= result.size())
                    result.add(endIndex, val1 + val2);
                else
                    result.set(endIndex, val1 + val2);
            }
            endIndex = (endIndex + 1) % (rowIndex + 1);
            if (endIndex >= result.size())
                result.add(endIndex, 1);
            else
                result.set(endIndex, 1);
        }

        //swap start+ to beginning
        int i = startIndex, j = rowIndex;
        while (i < j) {
            Integer temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
            i++;
            j--;
        }

        i = 0;
        j = startIndex - 1;
        while (i < j) {
            Integer temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
            i++;
            j--;
        }

        i = 0;
        j = rowIndex;
        while (i < j) {
            Integer temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
            i++;
            j--;
        }
        return result;
    }

}

package zhy2002.leetcode.solutions.pascalstriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0)
            return result;

        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);

        while (result.size() < numRows){
            List<Integer> previousRow = result.get(result.size() - 1);
            row = new ArrayList<>();
            for(int i=0; i<=previousRow.size(); i++){
                int previous = i - 1 < 0 ? 0 : previousRow.get(i - 1);
                int current = i == previousRow.size() ? 0 : previousRow.get(i);
                row.add(previous + current);
            }
            result.add(row);
        }
        return result;
    }

}

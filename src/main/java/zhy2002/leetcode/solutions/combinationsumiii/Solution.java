package zhy2002.leetcode.solutions.combinationsumiii;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * Loop through all combinations.
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> buffer = new ArrayList<>();
        for(int i=1; i<=k; i++){
            buffer.add(i);
        }

        List<List<Integer>> result = new ArrayList<>();

        while (true){
            int sum = 0;
            for(int number : buffer){
                sum+=number;
            }
            if(n == sum)
                result.add(new ArrayList<>(buffer));

            //progress to the next
            int i=buffer.size() - 1;
            while (i >= 0 && buffer.get(i) == 10 - (buffer.size() - i))
                i--;

            if(i < 0)
                break;

            buffer.set(i, buffer.get(i) + 1);
            for(int j=i + 1; j<buffer.size(); j++){
                buffer.set(j, buffer.get(j-1) + 1);
            }
        }

        return result;

    }


}

package zhy2002.leetcode.solutions.combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all combinations by recursively check all combinations with pruning.
 * This solution allows element to be 0 while the other two do not.
 */
public class RecursiveSolution implements Solution {

    //define these variables as fields to reduce size of recursion frame
    private List<List<Integer>> result;
    private List<Integer> buffer;
    private int sum;
    private int target;
    private int[] num;
    private int[] lastDifferent;

    public List<List<Integer>> combinationSum2(int[] num, int target) {

        this.target = target;
        this.num = num;
        Arrays.sort(num);
        this.sum = 0;//sum at the current path
        buffer = new ArrayList<>();//current path
        result = new ArrayList<>();//results
        lastDifferent = new int[num.length];//find last index with a different value in O(1)
        Arrays.fill(lastDifferent, -1);
        for (int i = 1; i < num.length; i++) {
            lastDifferent[i] = num[i] == num[i - 1] ? lastDifferent[i - 1] : i - 1;
        }
        findCombinations(0);//enumerate all combinations that contain num[0], and all combinations that dont contain num[0]
        return result;
    }

    private void findCombinations(int index) {

        if (index == num.length)//path ended
            return;

        if (num[index] > 0 && sum >= target)//pruning based on assumption
            return;

        findCombinations(index + 1);//without num[index]

        if (index > 0 && num[index] == num[index - 1]) { //avoid duplicate combinations
            int identicalCount = index - lastDifferent[index] - 1;//how many identical elements before index
            if (buffer.size() < identicalCount || !buffer.get(buffer.size() - identicalCount).equals(num[index]))//duplicate element at index can be selected if all proceeding identical elements are selected
                return;
        }

        buffer.add(num[index]);
        sum += num[index];
        if (target == sum) {
            result.add(new ArrayList<>(buffer));
        }
        findCombinations(index + 1); //with num[index]

        //restore
        buffer.remove(buffer.size() - 1);
        sum -= num[index];
    }
}

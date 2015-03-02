package zhy2002.leetcode.solutions.permutationsii;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/permutations-ii/
 */
public class Solution {

    private List<List<Integer>> result;
    private List<Integer> buffer;

    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        result = new ArrayList<>();
        buffer = new ArrayList<>();
        for (int number : num) {
            buffer.add(number);
        }

        permuteUnique(0);
        return result;
    }

    private void permuteUnique(int pos) {
        if (pos == buffer.size() - 1) {
            result.add(new ArrayList<>(buffer));
            return;
        }

        permuteUnique(pos + 1);
        for (int i = pos + 1; i < buffer.size(); i++) {
            if (!buffer.get(i).equals(buffer.get(i - 1)) && shiftIn(pos, i)) {
                permuteUnique(pos + 1);
                shiftOut(pos, i); //swap back
            }
        }
    }

    //need to maintain order
    private boolean shiftIn(int i, int j) {//assume i < j
        if (buffer.get(i).equals(buffer.get(j)))
            return false;

        Integer temp = buffer.get(j);
        while (j > i) {
            buffer.set(j, buffer.get(j - 1));
            j--;
        }
        buffer.set(i, temp);
        return true;
    }

    private boolean shiftOut(int i, int j) {//assume i < j
        Integer temp = buffer.get(i);
        while (j > i) {
            buffer.set(i, buffer.get(i + 1));
            i++;
        }
        buffer.set(j, temp);
        return true;
    }
}

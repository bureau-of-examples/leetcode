package zhy2002.leetcode.solutions.permutationsii;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class ListBufferSolution implements Solution {

    private List<List<Integer>> result;
    private List<Integer> buffer;

    //find unique permutations of elements in num.
    @Override
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        result = new ArrayList<>();
        //boxed copy of num
        buffer = new ArrayList<>();
        for (int number : num) {
            buffer.add(number);
        }
        //buffer is sorted
        permuteUnique(0);
        return result;
    }

    /**
     * get all unique permutation of sub-list[pos,].
     * Before start the sub-list should be sorted.
     * @param start of the sub-list.
     */
    private void permuteUnique(int pos) {

        //tail condition
        if (pos == buffer.size() - 1) {
            result.add(new ArrayList<>(buffer));
            return;
        }

        //get all permutations with the same [0,pos]
        permuteUnique(pos + 1);

        //in turn change the value at pos while maintaining the order of sub-list[pos+1,].
        for (int i = pos + 1; i < buffer.size(); i++) {
            //check for duplicates
            if (!buffer.get(i).equals(buffer.get(i - 1)) && !buffer.get(pos).equals(buffer.get(i))) {
                shiftIn(pos, i);
                permuteUnique(pos + 1);
                shiftOut(pos, i); //swap back
            }
        }
    }

    /**
     * Cyclic right shift on sub-list [i, j].
     * @param i start, inclusive.
     * @param j end, inclusive.
     * @return false if element i = element j.
     */
    private boolean shiftIn(int i, int j) {//assume i < j

        Integer temp = buffer.get(j);
        while (j > i) {
            buffer.set(j, buffer.get(j - 1));
            j--;
        }
        buffer.set(i, temp);
        return true;
    }

    /**
     * Cyclic left shift on sub-list [i, j].
     * @param i start, inclusive.
     * @param j end, inclusive.
     */
    private void shiftOut(int i, int j) {//assume i < j
        Integer temp = buffer.get(i);
        while (j > i) {
            buffer.set(i, buffer.get(i + 1));
            i++;
        }
        buffer.set(j, temp);
    }
}

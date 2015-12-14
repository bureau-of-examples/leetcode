package zhy2002.leetcode.solutions.factorcombinations;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/factor-combinations/
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * Note:
 * Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 */
public class Solution {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(n >= 1){
            getFactors(result, new LinkedList<>(), n);
        }
        return result;
    }

    private void getFactors(List<List<Integer>> result, LinkedList<Integer> prefix, int n){

        if(n == 1){
            if(prefix.size() >= 2){
                result.add(new ArrayList<>(prefix));
            }
            return;
        }

        int lastFactor = prefix.isEmpty() ? 2 : prefix.peekLast();
        if(n < lastFactor) {
            return;
        }

        if(prefix.size() >= 1){
            List<Integer> self = new ArrayList<>(prefix);
            self.add(n);
            result.add(self);
        }

        int bound = (int)Math.sqrt(n);
        for(int i=lastFactor; i<=bound; i++){
            if(n % i == 0){
                prefix.addLast(i);
                getFactors(result, prefix, n / i);
                prefix.removeLast();
            }
        }
    }



}

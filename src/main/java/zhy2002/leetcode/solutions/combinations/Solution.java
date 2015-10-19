package zhy2002.leetcode.solutions.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * Initially put an empty list in the collection.
 * For each list in the collection, in turn append all numbers - we generate all combinations of size k + 1 from all combinations of size k.
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        if(k > n || n < 0)
            throw new IllegalArgumentException();

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());//seed

        //increase combination size to i
        for(int i=1; i<=k; i++){
            int end = n - k - 1 + i;
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> list : result){
                int start = 0;
                if(list.size() > 0)
                    start = list.get(list.size() - 1);
                boolean first = true;
                for(int j=start; j<=end; j++){
                    List<Integer> newList;
                    if(first){
                        newList = list;
                        newList.add(j + 1);
                        first = false;
                    } else {
                        newList = new ArrayList<>(list);
                        newList.set(newList.size() - 1, j + 1);
                    }
                    temp.add(newList);
                }
            }

            result = temp;
        }
        return result;

    }
}



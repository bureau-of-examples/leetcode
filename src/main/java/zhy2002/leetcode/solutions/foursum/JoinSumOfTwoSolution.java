package zhy2002.leetcode.solutions.foursum;

import java.util.*;

/**
 * https://leetcode.com/discuss/20231/my-accepted-java-solution-by-making-use-of-twosum
 * Solution from the inter web people by joining two sum of twos.
 * This is slower than my solution in the OJ.
 */
public class JoinSumOfTwoSolution implements Solution {

    private static class Pair  {
        int ai, bi, a, b;//two indices and values
        Pair(int ai, int bi, int a, int b) {
            this.ai = ai;
            this.bi = bi;
            this.a = a;
            this.b = b;
        }

        boolean equals(Pair p) {
            return a == p.a && b == p.b;
        }
    }

    @Override
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);

        //build map for each pair: sum of pair -> list of pairs
        Map<Integer, List<Pair>> mapping = new TreeMap<>();
        for (int i=0; i<num.length-1; i++)
            for (int j=i+1; j<num.length; j++) {
                int sum = num[i] + num[j];
                List<Pair> comb = mapping.containsKey(sum) ? mapping.get(sum) : new ArrayList<Pair>();
                Pair pair = new Pair(i, j, num[i], num[j]);
                comb.add(pair);
                if (!mapping.containsKey(sum)) mapping.put(sum, comb);
            }

        List<List<Integer>> result = new ArrayList<>();
        for (int sum1 : mapping.keySet()) { //ordered because the use of tree set
            if (sum1 > target/2) break;//in the quadruple sum of first 2 <= sum of sum of last 2
            int sum2 = target - sum1;
            if (mapping.containsKey(sum2)) {
                Pair prevA = null;
                for (Pair comb1 : mapping.get(sum1)) {
                    if (prevA!=null && comb1.equals(prevA)) continue;//skip duplicates - all duplicates will be together in the sum list because num is sorted.
                    prevA = comb1;
                    Pair prevB = null;
                    for (Pair comb2 : mapping.get(sum2)) {
                        if (prevB != null && comb2.equals(prevB)) continue;//skip duplicates
                        if (comb1.bi < comb2.ai) {//join if in order
                            prevB = comb2;
                            List<Integer> quadruple = new ArrayList<>();
                            quadruple.add(comb1.a); quadruple.add(comb1.b);
                            quadruple.add(comb2.a); quadruple.add(comb2.b);
                            result.add(quadruple);
                        }
                    }
                }
            }
        }
        return result;
    }
}

package zhy2002.leetcode.solutions.sparsematrixmultiplication;

import java.util.HashMap;

/**
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 */
public class Solution {

    public int[][] multiply(int[][] A, int[][] B) {

        if (A.length == 0 || A[0].length == 0 || B.length == 0)
            return new int[0][0];

        int numRowA = A.length;
        int numColA = A[0].length;
        int numColB = B[0].length;
        int[][] result = new int[numRowA][numColB];

        HashMap<Integer, HashMap<Integer, Integer>> non0ElementsOfRows = new HashMap<>();
        for (int i = 0; i < numRowA; i++) {
            for (int j = 0; j < numColA; j++) {

                if (A[i][j] == 0)
                    continue;

                if (!non0ElementsOfRows.containsKey(i))
                    non0ElementsOfRows.put(i, new HashMap<>());
                non0ElementsOfRows.get(i).put(j, A[i][j]);
            }
        }

        HashMap<Integer, HashMap<Integer, Integer>> non0ElementsOfColumns = new HashMap<>();
        for (int i = 0; i < numColA; i++) {
            for (int j = 0; j < numColB; j++) {
                if (B[i][j] == 0)
                    continue;
                if (!non0ElementsOfColumns.containsKey(j))
                    non0ElementsOfColumns.put(j, new HashMap<>());
                non0ElementsOfColumns.get(j).put(i, B[i][j]);
            }
        }

        for(Integer m : non0ElementsOfRows.keySet()) {
            HashMap<Integer, Integer> rowElements = non0ElementsOfRows.get(m);
            for(Integer n : non0ElementsOfColumns.keySet()) {
                HashMap<Integer, Integer> colElements = non0ElementsOfColumns.get(n);
                for(Integer k : rowElements.keySet()) {
                    if (colElements.containsKey(k)) {
                        result[m][n] += rowElements.get(k) * colElements.get(k);
                    }
                }
            }
        }

        return result;
    }
}

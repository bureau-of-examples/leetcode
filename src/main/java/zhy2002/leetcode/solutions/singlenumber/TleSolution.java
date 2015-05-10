package zhy2002.leetcode.solutions.singlenumber;

/**
 * O(n) space TLE solution with hash map.
 */
public class TleSolution implements Solution  {

    @Override
    public int singleNumber(int[] A) {
        if (A.length % 2 != 1)
            throw new IllegalArgumentException("A");

        java.util.HashSet<Integer> hashSet = new java.util.HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (hashSet.contains(A[i]))
                hashSet.remove(A[i]);
            else
                hashSet.add(A[i]);
        }

        if (hashSet.size() != 1)
            throw new IllegalArgumentException("A");
        return hashSet.iterator().next();
    }
}

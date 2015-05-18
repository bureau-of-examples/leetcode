package zhy2002.leetcode.solutions.countprimes;

import java.util.Arrays;
import java.util.HashSet;


/**
 * https://leetcode.com/problems/count-primes/
 */
public class Solution {

    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        if (n <= 3)
            return 1;

        boolean[] flags = new boolean[n];
        Arrays.fill(flags, true);   //all as prime
        int bound = (int) Math.sqrt(n);

        for (int i = 3; i <= bound; i += 2) {
            if (flags[i]) {

                for (int j = i * i; j < n; j += i) {
                    if (j % i == 0) {
                        flags[j] = false;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 3; i < n; i+=2) {
            if (flags[i])
                count++;
        }
        return count + 1;
    }

    //tle
    public int countPrimes2(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0 && i != 2 || i % 3 == 0 && i != 3)
                hashSet.add(i);
        }

        int bound = (int) Math.sqrt(n);
        for (int i = 2; i <= bound; i++) {
            if (hashSet.contains(i)) {
                int j = i;
                while (j < n && j < 1073741824) {
                    j += i;
                    if (hashSet.contains(j))
                        hashSet.remove(j);
                }
            }
        }
        return hashSet.size();
    }
}

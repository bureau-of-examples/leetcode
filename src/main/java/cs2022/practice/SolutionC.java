package cs2022.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolutionC {

    private static final long MOD = 1000000007L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[][] dominoes = new int[count][2];
        for (int i = 0; i < count; i++) {
            dominoes[i][0] = scanner.nextInt();
            dominoes[i][1] = scanner.nextInt();
        }

        System.out.println(countWays(new HashMap<>(),dominoes, 0, 63));
    }

    private static long countWays(Map<Integer, Long> cache, int[][] dominoes, int used, int connBits) {
        int allUsed = (1 << dominoes.length) - 1;
        if (used == allUsed) {
            return 1;
        }

        // check cache
        int key = (connBits << 16) | used;
        var result = cache.get(key);
        if (result != null) {
            return result;
        }

        long count = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int bitFlag = 1 << i;
            if ((used & bitFlag) > 0) {
                continue;
            }

            int nextConnBits = 0;
            var d = dominoes[i]; // check if it can connect
            int bit0 = 1 << (d[0] - 1);
            int bit1 = 1 << (d[1] - 1);;
            if ((connBits & bit0) > 0) {
                nextConnBits |= bit1;
            }

            if ((connBits & bit1) > 0) {
                nextConnBits |= bit0;
            }
            if (nextConnBits == 0) {
                continue;
            }

            used |= bitFlag;
            count += countWays(cache, dominoes, used, nextConnBits);
            count %= MOD;
            used &= ~bitFlag;
        }

        cache.put(key, count);
        return count;
    }
}

package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/can-place-flowers/#/description
 */
public class CanPlaceFlowersTests {

    @Test
    public void test() {
        assertThat(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1), equalTo(true));
        assertThat(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2), equalTo(false));
        assertThat(canPlaceFlowers(new int[]{0}, 1), equalTo(true));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        int prev = 0;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int nextIndex = i + 1;
                int next = nextIndex == flowerbed.length ? 0 : flowerbed[nextIndex];
                if (prev == 0 && next == 0) {
                    count++;
                    if (count >= n)
                        return true;
                    prev = 1;
                    continue;
                }
            }
            prev = flowerbed[i];
        }
        return false;
    }
}

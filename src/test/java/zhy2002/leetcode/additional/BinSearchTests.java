package zhy2002.leetcode.additional;

import org.junit.Test;
import zhy2002.leetcode.solutions.searchinrotatedsortedarrayii.Solution;
/**
 * Binary search test playground.
 */
public class BinSearchTests {

    @Test
    public void test() {

        int[] input = new int[]{4,4,4,4,4,5,6,7,1,2,3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
        System.out.println(search(input, 0, input.length - 1, 5)); //book solution fails this test case

        Solution solution = new Solution();
        System.out.println(solution.search(input, 5)); //my code works
    }

    //solution from book
    private int search(int a[], int l, int u, int x) {
        while (l <= u) {
            int m = (l + u) / 2;
            if (x == a[m]) {
                return m;
            }

            if (a[l] <= a[m]) {
                if (x > a[m]) {
                    l = m + 1;
                } else if (x >= a[l]) {
                    u = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (x < a[m]) u = m - 1;
            else if (x <= a[u]) l = m + 1;
            else u = m - 1;
        }
        return -1;
    }
}

package zhy2002.leetcode.tests;

/**
 * https://leetcode.com/problems/first-bad-version/#/description
 */
public class FirstBadVersionTests {


    public class VersionControl {
        boolean isBadVersion(int version) {
            return false;
        }
    }

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int start = 1;
            int end = n;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (isBadVersion(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return start;
        }
    }
}

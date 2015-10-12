package zhy2002.leetcode.solutions.compareversionnumbers;

/**
 * Use split to compare each part.
 */
public class SplitSolution implements Solution {

    public int compareVersion(String version1, String version2) {

        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");

        int maxLen = parts1.length > parts2.length ? parts1.length : parts2.length;
        for (int i = 0; i < maxLen; i++) {

            int v1 = i < parts1.length ? Integer.parseInt(parts1[i]) : 0;
            int v2 = i < parts2.length ? Integer.parseInt(parts2[i]) : 0;
            if (v1 > v2)
                return 1;
            if (v2 > v1)
                return -1;
        }

        return 0;
    }
}

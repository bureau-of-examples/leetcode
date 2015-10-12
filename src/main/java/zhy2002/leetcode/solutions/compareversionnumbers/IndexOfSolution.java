package zhy2002.leetcode.solutions.compareversionnumbers;

/**
 * Use indexOf the progress to the next part.
 */
public class IndexOfSolution implements Solution {

    public int compareVersion(String version1, String version2) {

        int index1 = 0;
        int index2 = 0;

        version1 += ".";
        version2 += ".";

        while (true) {
            int nextIndex1 = version1.indexOf('.', index1);
            int nextIndex2 = version2.indexOf('.', index2);

            if (nextIndex1 == -1 && nextIndex2 == -1)
                break;

            int part1 = 0, part2 = 0;

            if (nextIndex1 != -1) {
                part1 = Integer.parseInt(version1.substring(index1, nextIndex1));
                index1 = nextIndex1 + 1;
            }

            if (nextIndex2 != -1) {
                part2 = Integer.parseInt(version2.substring(index2, nextIndex2));
                index2 = nextIndex2 + 1;
            }

            if (part1 > part2)
                return 1;

            if (part1 < part2)
                return -1;
        }

        return 0;
    }
}

package zhy2002.leetcode.solutions.findthecelebrity;

/**
 * https://leetcode.com/problems/find-the-celebrity/
 */
public class Solution extends Relation {

    public int findCelebrity(int n) {

        boolean[] cannotBeCelebrity = new boolean[n];

        NEXT_I:
        for (int i = 0; i < n; i++) {
            if (cannotBeCelebrity[i])
                continue;

            //check if everyone else knows i
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;

                if (knows(j, i)) {
                    cannotBeCelebrity[j] = true;
                } else {
                    continue NEXT_I;
                }
            }

            //check if i does not know anyone
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;

                if (knows(i, j)) {
                    continue NEXT_I;
                } else {
                    cannotBeCelebrity[j] = true;
                }
            }
            return i;
        }

        return -1;
    }
}

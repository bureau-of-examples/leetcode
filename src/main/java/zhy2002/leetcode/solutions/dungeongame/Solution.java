package zhy2002.leetcode.solutions.dungeongame;

/**
 * https://oj.leetcode.com/problems/dungeon-game/
 */
public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0)
            throw new IllegalArgumentException();

        final int height = dungeon.length;
        final int width = dungeon[0].length;
        int[] minStartHP = new int[width]; //min health required to reach princess from cell(i,j)

        //calc last row, last col
        int val = dungeon[height - 1][width - 1];
        minStartHP[width - 1] = val < 0 ? -val + 1 : 1;

        //calc last row
        int right;
        for (int j = width - 2; j >= 0; j--) { //last row
            val = dungeon[height - 1][j];
            right = minStartHP[j + 1];
            minStartHP[j] = right > val ?  right - val : 1;/*so that j+1 has minStartHealth[j+1] but min is 1*/
        }

        for (int i = height - 2; i >= 0; i--) {

            //calc last col
            val = dungeon[i][width - 1];
            int bottom = minStartHP[width - 1];
            minStartHP[width - 1] = bottom > val ? bottom - val : 1;

            //calc row
            for (int j = width - 2; j >= 0; j--) {
                right = minStartHP[j + 1];
                bottom = minStartHP[j];
                val = dungeon[i][j];

                int minHPGoToRight = right > val ? right - val : 1;
                int minHPGoToBottom = bottom > val ? bottom - val : 1;
                minStartHP[j] = minHPGoToRight < minHPGoToBottom ? minHPGoToRight : minHPGoToBottom;
            }
        }

        return minStartHP[0];
    }
}

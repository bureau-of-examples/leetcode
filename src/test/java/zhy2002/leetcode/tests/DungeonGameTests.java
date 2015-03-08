package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.dungeongame.Solution;
import org.junit.Test;

import static org.junit.Assert.*;

public class DungeonGameTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        int[][] dungeon1 = {{-3}};
        assertEquals(4, solution.calculateMinimumHP(dungeon1));

        int[][] dungeon2 = {{4}};
        assertEquals(1, solution.calculateMinimumHP(dungeon2));

        int[][] dungeon3 = {{2, 1}};
        assertEquals(1, solution.calculateMinimumHP(dungeon3));

        int[][] dungeon4 = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};
        assertEquals(3, solution.calculateMinimumHP(dungeon4));

        int[][] dungeon5 =  {{10,4,-48,-8,-87,9},{49,-100,6,-15,41,-99},{-76,-45,-26,50,46,14},{-81,-92,46,-62,-26,1},{-44,19,26,-98,-49,-72}};
        assertEquals(44, solution.calculateMinimumHP(dungeon5));
    }
}

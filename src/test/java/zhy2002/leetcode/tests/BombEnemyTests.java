package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.bombenemy.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class BombEnemyTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        int result = solution.maxKilledEnemies(new char[0][0]);
        assertThat(result, equalTo(0));

        result = solution.maxKilledEnemies(new char[][]{
                {'0', 'E', 'E', 'W', '0'}
        });
        assertThat(result, equalTo(2));

        result = solution.maxKilledEnemies(new char[][]{
                {'0', 'E', 'E', 'W', '0'},
                {'E', 'W', 'W', '0', 'E'}
        });
        assertThat(result, equalTo(3));

        result = solution.maxKilledEnemies(new char[][]{
                {'E', 'E', 'E'},
                {'E', '0', 'E'},
                {'E', 'E', 'E'}
        });
        assertThat(result, equalTo(4));

        result = solution.maxKilledEnemies(new char[][]{
                {'0', 'E', 'E'},
                {'E', '0', '0'},
                {'E', 'E', 'E'}
        });
        assertThat(result, equalTo(4));

        result = solution.maxKilledEnemies(new char[][]{
                {'0', 'E', 'E', 'E'},
                {'E', '0', '0', 'E'},
                {'E', 'E', 'E', '0'}
        });
        assertThat(result, equalTo(5));

        result = solution.maxKilledEnemies(new char[][]{
                {'0', 'E', '0', 'E'},
                {'E', '0', '0', 'E'},
                {'E', 'W', 'E', '0'}
        });
        assertThat(result, equalTo(4));

    }
}

package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.waterandjugproblem.*;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WaterAndJugProblemTests {

    @Test
    public void mathBasicTest() {
        basicTest(new MathSolution());
    }

    @Test
    public void bfsBasicTest() {
        basicTest(new BFSSolution());
    }

    @Test
    public void randomComparisonTest() {
        BFSSolution solution1 = new BFSSolution();
        MathSolution solution2 = new MathSolution();
        Random random = new Random(5);
        for(int i=0; i<20; i++) {
            int x = random.nextInt(50);
            int y = random.nextInt(50);
            int z = random.nextInt(120);
            assertThat(solution1.canMeasureWater(x, y, z), equalTo(solution2.canMeasureWater(x, y, z)));
        }
    }

    private void basicTest(Solution solution) {
        assertThat(solution.canMeasureWater(3, 5, 4), equalTo(true));
        assertThat(solution.canMeasureWater(5, 11, 1), equalTo(true));
        assertThat(solution.canMeasureWater(6, 4, 7), equalTo(false));
        assertThat(solution.canMeasureWater(2, 6, 7), equalTo(false));
        assertThat(solution.canMeasureWater(8, 8, 8), equalTo(true));
        assertThat(solution.canMeasureWater(8, 4, 4), equalTo(true));
        assertThat(solution.canMeasureWater(8, 0, 4), equalTo(false));
    }
}

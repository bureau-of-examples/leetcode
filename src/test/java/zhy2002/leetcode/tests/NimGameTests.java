package zhy2002.leetcode.tests;


import zhy2002.leetcode.solutions.nimgame.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class NimGameTests {

    @Test
    public void dpTest(){
        basicTest(new DpSolution());
    }

    @Test
    public void cheatTest(){
         basicTest(new CheatSolution());
    }


    private void basicTest(Solution solution){


        assertThat(solution.canWinNim(1), equalTo(true));
        assertThat(solution.canWinNim(3), equalTo(true));
        assertThat(solution.canWinNim(4), equalTo(false));
        assertThat(solution.canWinNim(7), equalTo(true));
        assertThat(solution.canWinNim(8), equalTo(false));
        assertThat(solution.canWinNim(9), equalTo(true));
        assertThat(solution.canWinNim(1348820612), equalTo(false));


    }
}

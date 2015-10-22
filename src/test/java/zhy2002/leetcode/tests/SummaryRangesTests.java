package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.summaryranges.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SummaryRangesTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        List<String> result = solution.summaryRanges(new int[]{0,1,2,4,5,7});
        assertThat(result, equalTo(Arrays.asList("0->2","4->5","7")));

        result = solution.summaryRanges(new int[0]);
        assertThat(result, equalTo(new ArrayList<>()));

        result = solution.summaryRanges(new int[]{-10, 20, 30, 80});
        assertThat(result, equalTo(Arrays.asList("-10","20","30", "80")));

        result = solution.summaryRanges(new int[]{-10, 20, 30, 80, 81});
        assertThat(result, equalTo(Arrays.asList("-10","20","30", "80->81")));

        result = solution.summaryRanges(new int[]{-10, 20,21,22,23,24,25,26,27,28, 30, 80, 81});
        assertThat(result, equalTo(Arrays.asList("-10","20->28","30", "80->81")));

        result = solution.summaryRanges(new int[]{-10, 20,21,22,23,24,25,26,27,28, 30,31, 80, 81});
        assertThat(result, equalTo(Arrays.asList("-10","20->28","30->31", "80->81")));
    }
}

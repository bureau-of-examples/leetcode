package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.verifypreorderserializationofabinarytree.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class VerifyPreorderSerializationOfABinaryTreeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertThat(solution.isValidSerialization(""), equalTo(false));
        assertThat(solution.isValidSerialization("#"), equalTo(true));
        assertThat(solution.isValidSerialization("#,2"), equalTo(false));
        assertThat(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"), equalTo(true));
        assertThat(solution.isValidSerialization("1,#"), equalTo(false));
        assertThat(solution.isValidSerialization("9,#,#,1"), equalTo(false));
        assertThat(solution.isValidSerialization("9,#,1,1,2,3,#,1"), equalTo(false));
        assertThat(solution.isValidSerialization("9,#,1,#,1,2,3,#,1,#"), equalTo(false));
        assertThat(solution.isValidSerialization("3,1,5,6,#,#,#,2,3,#,8,#,#,#,4,#,8,4,#,#,9,#,#"), equalTo(true));
    }
}

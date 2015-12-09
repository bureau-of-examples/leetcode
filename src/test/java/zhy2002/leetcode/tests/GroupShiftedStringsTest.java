package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.groupshiftedstrings.Solution;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupShiftedStringsTest {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        List<List<String>> result = solution.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});
        String resultStr = Utils.listOfListToString(result);
        assertThat(resultStr, equalTo("[[a,z],[abc,bcd,xyz],[acef],[az,ba]]"));

        result = solution.groupStrings(new String[]{"aaec", "zzdb"});
        assertThat(result, hasSize(1));

        result = solution.groupStrings(new String[]{"aaec", "zzdb", "bbff"});
        assertThat(result, hasSize(2));

        result = solution.groupStrings(new String[]{"abc","am"});
        assertThat(result, hasSize(2));
    }
}

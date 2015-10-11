package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.readncharactersgivenread4ii.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ReadNCharactersGivenRead4IITests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        solution.setFileContent("Hello World!");
        char[] buffer = new char[8];
        int readCount = solution.read(buffer, 7);
        assertThat(readCount, equalTo(7));
        assertThat(buffer, equalTo(new char[]{'H','e','l','l','o',' ','W','\0'}));

        readCount = solution.read(buffer, 7);
        assertThat(readCount, equalTo(5));
        assertThat(buffer, equalTo(new char[]{'o','r','l','d','!',' ','W','\0'}));

        solution.setFileContent("The road is long with many a winding turns");
        readCount = solution.read(buffer, 8);
        assertThat(readCount, equalTo(8));
        assertThat(buffer, equalTo(new char[]{'T','h','e',' ','r','o','a','d'}));

        readCount = solution.read(buffer, 8);
        assertThat(readCount, equalTo(8));
        assertThat(buffer, equalTo(new char[]{' ','i','s',' ','l','o','n','g'}));

        readCount = solution.read(buffer, 8);
        assertThat(readCount, equalTo(8));
        assertThat(buffer, equalTo(new char[]{' ','w','i','t','h',' ','m','a'}));

        readCount = solution.read(buffer, 8);
        assertThat(readCount, equalTo(8));
        assertThat(buffer, equalTo(new char[]{'n','y',' ','a',' ','w','i','n'}));

        readCount = solution.read(buffer, 8);
        assertThat(readCount, equalTo(8));
        assertThat(buffer, equalTo(new char[]{'d','i','n','g',' ','t','u','r'}));

        readCount = solution.read(buffer, 8);
        assertThat(readCount, equalTo(2));
        assertThat(buffer, equalTo(new char[]{'n','s','n','g',' ','t','u','r'}));

        readCount = solution.read(buffer, 8);
        assertThat(readCount, equalTo(0));
        assertThat(buffer, equalTo(new char[]{'n','s','n','g',' ','t','u','r'}));
    }
}

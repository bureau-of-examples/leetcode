package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.readncharactersgivenread4.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ReadNCharactersGivenRead4Tests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        solution.setFileContent("");
        char[] buffer = new char[9];
        int readCount = solution.read(buffer, 9);
        assertThat(readCount, equalTo(0));
        assertThat(buffer[0], equalTo('\0'));

        solution.setFileContent("Hello World!");
        buffer = new char[4];
        readCount = solution.read(buffer, 3);
        assertThat(readCount, equalTo(3));
        assertThat(buffer, equalTo(new char[]{'H', 'e', 'l', '\0'}));

        solution.setFileContent("Hello World!");
        buffer = new char[4];
        readCount = solution.read(buffer, 4);
        assertThat(readCount, equalTo(4));
        assertThat(buffer, equalTo(new char[]{'H', 'e', 'l', 'l'}));

        solution.setFileContent("Hello World!");
        buffer = new char[10];
        readCount = solution.read(buffer, 5);
        assertThat(readCount, equalTo(5));
        assertThat(buffer, equalTo(new char[]{'H', 'e', 'l', 'l', 'o', '\0', '\0', '\0', '\0', '\0'}));

        solution.setFileContent("Hello World!");
        buffer = new char[10];
        readCount = solution.read(buffer, 9);
        assertThat(readCount, equalTo(9));
        assertThat(buffer, equalTo(new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', '\0'}));

        solution.setFileContent("Hello World!");
        buffer = new char[13];
        readCount = solution.read(buffer, 13);
        assertThat(readCount, equalTo(12));
        assertThat(buffer, equalTo(new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!', '\0'}));

    }
}

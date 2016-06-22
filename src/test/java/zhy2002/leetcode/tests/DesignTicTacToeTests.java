package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.designtictactoe.TicTacToe;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class DesignTicTacToeTests {

    @Test
    public void basicTest() {
        TicTacToe ticTacToe = new TicTacToe(3);
        assertThat(ticTacToe.move(0, 0, 1), equalTo(0));
        assertThat(ticTacToe.move(0, 2, 2), equalTo(0));
        assertThat(ticTacToe.move(2, 2, 1), equalTo(0));
        assertThat(ticTacToe.move(1, 1, 2), equalTo(0));
        assertThat(ticTacToe.move(2, 0, 1), equalTo(0));
        assertThat(ticTacToe.move(1, 0, 2), equalTo(0));
        assertThat(ticTacToe.move(2, 1, 1), equalTo(1));

        ticTacToe = new TicTacToe(3);
        assertThat(ticTacToe.move(0, 0, 1), equalTo(0));
        assertThat(ticTacToe.move(0, 1, 2), equalTo(0));
        assertThat(ticTacToe.move(1, 1, 1), equalTo(0));
        assertThat(ticTacToe.move(0, 2, 2), equalTo(0));
        assertThat(ticTacToe.move(2, 2, 1), equalTo(1));

        ticTacToe = new TicTacToe(3);
        assertThat(ticTacToe.move(0, 0, 1), equalTo(0));
        assertThat(ticTacToe.move(0, 2, 2), equalTo(0));
        assertThat(ticTacToe.move(1, 2, 1), equalTo(0));
        assertThat(ticTacToe.move(2, 0, 2), equalTo(0));
        assertThat(ticTacToe.move(2, 1, 1), equalTo(0));
        assertThat(ticTacToe.move(1, 1, 2), equalTo(2));
    }
}

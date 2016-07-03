package zhy2002.leetcode.additional;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Playground for recursion techniques.
 */
public class RecursionTests {

    @Test
    public void enumerateSubsetsTest() {
        enumerateSubsets(Arrays.asList());
        System.out.println("-----------");
        enumerateSubsets(Arrays.asList(1));
        System.out.println("-----------");
        enumerateSubsets(Arrays.asList(1, 2));
        System.out.println("-----------");
        enumerateSubsets(Arrays.asList(1, 2, 3));
        System.out.println("-----------");
    }

    @Test
    public void calcWaysTest() {
        System.out.println(calcWays(0));
        System.out.println(calcWays(1));
        System.out.println(calcWays(4));
        System.out.println(calcWays(5));
        System.out.println(calcWays(10));
        System.out.println(calcWays(25));
    }

    private int calcWays(int amount) {
        return calcWays(amount, 25);
    }

    private int calcWays(int amount, int maxDenomination) {
        if (amount == 0 || maxDenomination == 1)
            return 1;
        int nextMax = nextDenomination(maxDenomination);
        int ways = 0;
        while (amount >= 0) {
            ways += calcWays(amount, nextMax);
            amount -= maxDenomination;
        }
        return ways;
    }

    private int nextDenomination(int denomination) {
        if (denomination == 25)
            return 10;
        if (denomination == 10)
            return 5;
        if (denomination == 5)
            return 1;
        throw new IllegalArgumentException("denomination");
    }

    private void enumerateSubsets(List<?> list) {
        LinkedList<Object> buffer = new LinkedList<>();
        enumerateSubsets(list, 0, buffer);
    }

    private void enumerateSubsets(List<?> list, int index, LinkedList<Object> buffer) {
        if (index == list.size()) {
            System.out.println(buffer);
            return;
        }

        enumerateSubsets(list, index + 1, buffer);
        buffer.addLast(list.get(index));
        enumerateSubsets(list, index + 1, buffer);
        buffer.removeLast();
    }
}

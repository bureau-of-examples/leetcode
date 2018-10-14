package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.maxstack.MaxStack;

public class MaxStackTests {

    @Test
    public void test() {
        MaxStack stack = new MaxStack();
        stack.push(4);
        stack.push(67);
        stack.popMax();
        stack.push(2);
        stack.peekMax();
        stack.popMax();
        stack.popMax();
        stack.push(45);

    }

    /*
                 "push","push","push","push","push","push","top","push","push","push","push","push"]
                 ,[],[],[],[45],[-42],[-90],[-57],[-1],[-60],[],[67],[-67],[-5],[-90],[-49]]

    */
}

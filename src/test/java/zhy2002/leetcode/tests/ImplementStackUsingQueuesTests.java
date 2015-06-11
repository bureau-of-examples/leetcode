package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.implementstackusingqueues.MyStack;
import static org.junit.Assert.*;

public class ImplementStackUsingQueuesTests {

    @Test
    public void basicTest(){
        MyStack stack = new MyStack();
        assertEquals(true, stack.empty());

        stack.push(1);
        assertEquals(false, stack.empty());

        stack.push(2);
        assertEquals(2, stack.top());

        stack.pop();
        assertEquals(1, stack.top());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.top());

        stack.pop();
        assertEquals(2, stack.top());

        stack.push(4);
        assertEquals(4, stack.top());


    }
}

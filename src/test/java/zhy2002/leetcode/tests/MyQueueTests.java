package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.implementqueueusingstacks.MyQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class MyQueueTests {

    @Test
    public void basicTest() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        assertThat(queue.peek(), equalTo(1));
        queue.push(2);
        assertThat(queue.peek(), equalTo(1));
        queue.pop();
        assertThat(queue.peek(), equalTo(2));
        queue.pop();
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.pop();
        queue.push(6);

        assertThat(queue.peek(), equalTo(4));
        queue.pop();
        assertThat(queue.peek(), equalTo(5));
        queue.pop();
        assertThat(queue.peek(), equalTo(6));
        queue.push(7);
        assertThat(queue.peek(), equalTo(6));

    }
}

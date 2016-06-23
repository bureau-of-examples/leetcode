package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.loggerratelimiter.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoggerRateLimiterTests {

    @Test
    public void basicTest() {
        Logger logger = new Logger();

        // logging string "foo" at timestamp 1
        boolean result = logger.shouldPrintMessage(1, "foo");
        assertThat(result, equalTo(true));

// logging string "bar" at timestamp 2
        result = logger.shouldPrintMessage(2, "bar");
        assertThat(result, equalTo(true));

// logging string "foo" at timestamp 3
        result = logger.shouldPrintMessage(3, "foo");
        assertThat(result, equalTo(false));

// logging string "bar" at timestamp 8
        result = logger.shouldPrintMessage(8, "bar");
        assertThat(result, equalTo(false));

// logging string "foo" at timestamp 10
        result = logger.shouldPrintMessage(10, "foo");
        assertThat(result, equalTo(false));

// logging string "foo" at timestamp 11
        result = logger.shouldPrintMessage(11, "foo");
        assertThat(result, equalTo(true));
    }
}

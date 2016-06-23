package zhy2002.leetcode.solutions.loggerratelimiter;

import java.util.*;

import static com.sun.corba.se.impl.util.RepositoryId.cache;

/**
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 * <p>
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 * <p>
 * It is possible that several messages arrive roughly at the same time.
 * <p>
 * Example:
 * <p>
 * Logger logger = new Logger();
 * <p>
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;
 * <p>
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * <p>
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * <p>
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * <p>
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * <p>
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 */
public class Logger {

    private Map<Integer, HashSet<String>> messages = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Logger() {
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        clearOldEntries(timestamp);
        boolean result = hasMessage(message);
        if (!result) {
            addMessage(timestamp, message);
        }
        return !result;
    }

    private boolean hasMessage(String message) {
        for (HashSet<String> messageSet : messages.values()) {
            if (messageSet.contains(message))
                return true;
        }
        return false;
    }

    private void addMessage(int timestamp, String message) {
        if (!messages.containsKey(timestamp)) {
            messages.put(timestamp, new HashSet<>());
        }
        messages.get(timestamp).add(message);
    }

    private void clearOldEntries(int timestamp) {
        Iterator<Integer> iterator = messages.keySet().iterator();
        while (iterator.hasNext()) {
            int oldTimestamp = iterator.next();
            if (timestamp - oldTimestamp >= 10) {
                iterator.remove();
            }
        }
    }
}

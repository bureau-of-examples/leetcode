package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/#/description
 */
public class InsertDeleteGetRandomO1Tests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class RandomizedSet {

        private Random random = new Random();
        private boolean needCompact;
        private List<Integer> list = new ArrayList<>();
        private Map<Integer, Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
        }

        /**
         * Inserts a value to the map. Returns true if the map did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val))
                return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the map. Returns true if the map contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;
            list.set(map.get(val), null);
            needCompact = true;
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the map.
         */
        public int getRandom() {
            ensureCompact();
            return list.get(random.nextInt(list.size()));
        }

        private void ensureCompact() {
            if (!needCompact)
                return;
            List<Integer> compact = new ArrayList<>();
            for (Integer val : list) {
                if (val == null)
                    continue;
                map.put(val, compact.size());
                compact.add(val);
            }
            list = compact;
            needCompact = false;
        }
    }

}

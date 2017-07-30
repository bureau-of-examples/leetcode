package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/lfu-cache/discuss/
 */
public class LFUCache2Tests {

    @Test
    public void test() {
        LFUCache cache = new LFUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

        //assertThat(cache.get(1), equalTo(2));
    }

    public class LFUCache {

        private final int capacity;
        private Map<Integer, Integer> valueMap = new HashMap<>(); //value of a key
        private Map<Integer, Integer> countMap = new HashMap<>(); //access count of a key
        private Map<Integer, LinkedHashSet<Integer>> countKeys = new HashMap<>(); //keys with this access count
        private int min = 0; //track the min access count

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!valueMap.containsKey(key)) {
                return -1;
            }
            increaseCount(key);
            return valueMap.get(key);
        }

        public void put(int key, int value) {
            if (capacity == 0)
                return;
            increaseCount(key);
            valueMap.put(key, value);
        }

        public void increaseCount(int key) {
            if (countMap.containsKey(key)) { //increase count of key by 1
                int oldCount = countMap.get(key);
                int newCount = oldCount + 1;
                //remove from old count bucket
                LinkedHashSet<Integer> keys = countKeys.get(oldCount);
                keys.remove(key);
                if (keys.isEmpty()) {
                    countKeys.remove(oldCount);
                    if (oldCount == min)
                        min = newCount;
                }
                //add to new count bucket
                countMap.put(key, newCount);
                countKeys.computeIfAbsent(newCount, c -> new LinkedHashSet<>()).add(key);
            } else { //add new key
                if (countMap.size() == capacity) {//remove oldest key in min count bucket
                    Set<Integer> minKeys = countKeys.get(min);
                    Integer toBeRemoved = minKeys.iterator().next();
                    valueMap.remove(toBeRemoved);
                    countMap.remove(toBeRemoved);
                    minKeys.remove(toBeRemoved);
                    if (minKeys.isEmpty()) {
                        countKeys.remove(min);
                    }
                }
                countMap.put(key, 1);
                min = 1;
                countKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            }
        }
    }
}

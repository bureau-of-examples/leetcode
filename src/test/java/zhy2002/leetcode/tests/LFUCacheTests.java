package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/lfu-cache/#/description
 */
public class LFUCacheTests {

    @Test
    public void test() {
        Random random = new Random(9);
        LFUCache lfuCacheR = new LFUCache(5);
        for (int i = 0; i < 1000; i++) {

            if (random.nextInt(10) < 3) {
                lfuCacheR.put(random.nextInt(100), random.nextInt(1000));
            } else {
                lfuCacheR.get(random.nextInt(100));
            }
        }
        System.out.println("rand");

        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 100);
        lfuCache.put(1, 101);
        assertThat(lfuCache.get(1), equalTo(101));

        lfuCache.put(2, 201);
        lfuCache.put(3, 301);
        assertThat(lfuCache.get(2), equalTo(-1));
        lfuCache.put(3, 302);
        lfuCache.put(3, 303);
        lfuCache.put(4, 401);
        assertThat(lfuCache.get(1), equalTo(-1));
    }

    public class LFUCache {

        private class Frequency { //contains the keys whose use count is 'count'
            int count;
            final LinkedHashSet<Integer> keys = new LinkedHashSet<>();
            Frequency previous;
            Frequency next;

            Frequency(int key, int count, Frequency previous) {
                keys.add(key);
                this.count = count;
                this.previous = previous;
            }
        }

        private int capacity;
        private Map<Integer, Integer> valueMap = new HashMap<>();
        private Map<Integer, Frequency> frequencyMap = new HashMap<>();
        private Frequency head; //lowest frequency are placed at head

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer value = valueMap.get(key);
            if (value == null) {
                return -1;
            }
            increaseCount(key);
            return value;
        }

        private void increaseCount(int key) {
            Frequency frequency = frequencyMap.get(key);
            Frequency newFrequency;
            if (frequency == null) {
                if (head != null && head.count == 1) {
                    newFrequency = head;
                    newFrequency.keys.add(key);
                } else {
                    newFrequency = new Frequency(key, 1, null);
                    newFrequency.next = head;
                    if (head != null) {
                        head.previous = newFrequency;
                    }
                    head = newFrequency;
                }
            } else {
                frequency.keys.remove(key);

                int newCount = frequency.count + 1;
                if (frequency.next != null && frequency.next.count == newCount) {
                    newFrequency = frequency.next;
                    newFrequency.keys.add(key);
                } else {
                    newFrequency = new Frequency(key, newCount, frequency);
                    Frequency next = frequency.next;
                    frequency.next = newFrequency;
                    if (next != null) {
                        next.previous = newFrequency;
                    }
                    newFrequency.next = next;
                }

                if (frequency.keys.size() == 0) { //remove empty slot
                    removeEmptySlot(frequency);
                }
            }
            frequencyMap.put(key, newFrequency);
        }

        private void removeEmptySlot(Frequency frequency) {
            Frequency previous = frequency.previous;
            Frequency next = frequency.next;
            if (previous != null) {
                previous.next = next;
            } else {
                head = next;
            }
            if (next != null) {
                next.previous = previous;
            }
        }

        public void put(int key, int value) {
            if (capacity == 0)
                return;

            if (valueMap.size() == capacity && !valueMap.containsKey(key)) {
                removeOldest();
            }
            valueMap.put(key, value);
            increaseCount(key);
        }

        private void removeOldest() {
            Integer oldestKey = head.keys.iterator().next();
            head.keys.remove(oldestKey);
            if (head.keys.size() == 0) {
                removeEmptySlot(head);
            }
            valueMap.remove(oldestKey);
            frequencyMap.remove(oldestKey);
        }
    }

}

package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.lrucache.LRUCache;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LRUCacheTests {

    //cache miss will return -1
    @Test
    public void basicTest(){
        LRUCache cache = new LRUCache(2);
        cache.set(1,1);
        cache.set(2,2);
        assertThat(cache.get(1), equalTo(1));

        cache.set(3,3);
        assertThat(cache.get(1), equalTo(1));
        assertThat(cache.get(3), equalTo(3));
        assertThat(cache.get(2), equalTo(-1));

        cache.set(4,4);
        assertThat(cache.get(1), equalTo(-1));

        cache = new LRUCache(2);
        cache.set(2,1);
        cache.set(2,2);
        assertThat(cache.get(2), equalTo(2));

        cache.set(1,1);
        cache.set(4,1);
        assertThat(cache.get(2), equalTo(-1));

        cache = new LRUCache(3);
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
        assertThat(cache.get(4), equalTo(4));
        assertThat(cache.get(3), equalTo(3));
        assertThat(cache.get(2), equalTo(2));
        assertThat(cache.get(1), equalTo(-1));

        cache.set(5,5);
        assertThat(cache.get(1),equalTo(-1));
        assertThat(cache.get(2),equalTo(2));
        assertThat(cache.get(3),equalTo(3));
        assertThat(cache.get(4),equalTo(-1));
        assertThat(cache.get(5),equalTo(5));
    }
}

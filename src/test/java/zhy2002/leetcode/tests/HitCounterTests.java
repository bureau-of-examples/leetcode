package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.designhitcounter.HitCounter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HitCounterTests {

    @Test
    public void basicTest() {
        HitCounter hitCounter = new HitCounter();

        hitCounter.hit(1);
        assertThat(hitCounter.getHits(1), equalTo(1));

        hitCounter.hit(1);
        assertThat(hitCounter.getHits(10), equalTo(2));

        hitCounter.hit(10);
        assertThat(hitCounter.getHits(10), equalTo(3));

        hitCounter.hit(300);
        assertThat(hitCounter.getHits(300), equalTo(4));

        hitCounter.hit(301);
        assertThat(hitCounter.getHits(302), equalTo(3));

        hitCounter.hit(1000);
        assertThat(hitCounter.getHits(1001), equalTo(1));

        hitCounter.hit(1001);
        assertThat(hitCounter.getHits(1001), equalTo(2));

        hitCounter.hit(1300);
        assertThat(hitCounter.getHits(1300), equalTo(2));

        hitCounter.hit(1301);
        assertThat(hitCounter.getHits(1301), equalTo(2));

        hitCounter.hit(1303);
        assertThat(hitCounter.getHits(1304), equalTo(3));
    }

    @Test
    public void boundaryTest() {
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        assertThat(hitCounter.getHits(4), equalTo(3));
        hitCounter.hit(300);
        assertThat(hitCounter.getHits(300), equalTo(4));
        assertThat(hitCounter.getHits(301), equalTo(3));
    }
}

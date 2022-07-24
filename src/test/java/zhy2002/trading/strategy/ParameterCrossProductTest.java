package zhy2002.trading.strategy;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ParameterCrossProductTest {

    @Test
    public void noParameter() {
        var g = new ParameterCrossProduct();
        assertThat(g.hasNext(), equalTo(true));
        assertThat(g.next(), equalTo(g));
        assertThat(g.hasNext(), equalTo(false));
    }

    @Test
    public void testSingle() {
        var g = new ParameterCrossProduct().withParameter("t1", new int[]{1, 2, 3});
        while (g.hasNext()) {
            System.out.println(g.next().getInt("t1"));
        }
    }

    @Test
    public void testTwo() {
        var g = new ParameterCrossProduct()
                .withParameter("t1", new int[]{1, 2, 3})
                .withParameter("t2", new double[]{1.0, 2.0, 3.0});

        while (g.hasNext()) {
            var p = g.next();
            System.out.println(p.getInt("t1") + ", " + p.getDouble("t2"));
        }
    }

    @Test
    public void testThree() {
        var g = new ParameterCrossProduct()
                .withParameter("t1", new int[]{1, 2, 3})
                .withParameter("t2", new double[]{1.0, 2.0, 3.0})
                .withParameter("t3", new double[]{0.1, 0.2});

        while (g.hasNext()) {
            var p = g.next();
            System.out.println(p);
        }
    }

}

package zhy2002.trading.indicator;

import org.junit.Test;
import zhy2002.trading.Chart;

public class StochasticTest {

    @Test
    public void test() {
        var chart = new Chart("NAB.AX");
        var index = chart.findDateIndex("2020-11-19");
        var st = chart.getStochastic();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.2f, %.2f\n", st.getK(index + i), st.getD(index + i));
        }
    }

}
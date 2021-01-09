package zhy2002.trading.indicator;

import org.junit.Test;
import zhy2002.trading.Chart;

public class EMATest {

    @Test
    public void test() {
        var chart = new Chart("NAB.AX");
        var ema = new EMA(chart, 20);
        var index = chart.findDateIndex("2020-11-19");
        for (int i=0; i<10; i++) {
            System.out.println(ema.get(index + i));
        }
    }
}

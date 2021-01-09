package zhy2002.trading.indicator;

import org.junit.Test;
import zhy2002.trading.Chart;

public class ATRTest {

    @Test
    public void test() {
        var chart = new Chart("NAB.AX");
        var atr = new ATR(chart, 14);
        var index = chart.findDateIndex("2020-11-19");
        for (int i = 0; i < 10; i++) {
            System.out.println(atr.get(index + i));
        }
    }
}

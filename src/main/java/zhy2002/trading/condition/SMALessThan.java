package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;


@AllArgsConstructor
public class SMALessThan implements TradeCondition {

    private final int smaPeriod1;
    private final int smaPeriod2;
    private final int window;
    private final double percent;


    public boolean isMet(Chart chart, int index) {
        var sma1 = chart.getSMA(smaPeriod1);
        var sma2 = chart.getSMA(smaPeriod2);
        for (int i = 0; i < window; i++) {
            var v1 = sma1.get(index - i);
            var v2 = sma2.get(index - i);
            if ((v1 - v2) >= v2 * percent) {
                return false;
            }
        }
        return true;
    }

}

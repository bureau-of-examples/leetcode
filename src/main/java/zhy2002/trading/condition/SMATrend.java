package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class SMATrend extends ChartTradeCondition {

    private final int smaPeriods;
    private final Comparison comparison;
    private final int window;

    public boolean isMet(Chart chart, int index) {
        var sma = chart.getSMA(smaPeriods);
        for (int i = 0; i < window; i++) {
            double previous = sma.get(index - i - 1);
            double current = sma.get(index - i);
            if (!comparison.isTrue(current, previous)) {
                return false;
            }
        }
        return true;
    }
}

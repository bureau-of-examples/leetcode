package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class CompareWithSMA implements TradeCondition {

    private static final int WINDOW = 1;
    private final Comparison comparison;
    private final int smaPeriods;

    @Override
    public boolean isMet(Chart chart, int index) {
        var sma = chart.getSMA(smaPeriods);
        for (int i = 0; i < WINDOW; i++) {
            if (!comparison.isTrue(chart.getCandle(index - i).getClose(), sma.get(index - i - 1))) {
                return false;
            }
        }
        return true;
    }
}

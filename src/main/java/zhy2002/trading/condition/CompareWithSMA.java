package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

/**
 * Compares the current close prise with SMA.
 */
@AllArgsConstructor
public class CompareWithSMA extends ChartTradeCondition {

    private final Comparison comparison;
    private final int smaPeriods;
    private final int window;

    public CompareWithSMA(Comparison comparison) {
        this(comparison, 100);
    }

    public CompareWithSMA(Comparison comparison, int smaPeriods) {
        this(comparison, smaPeriods, 1);
    }

    @Override
    public boolean isMet(Chart chart, int index) {
        var sma = chart.getSMA(smaPeriods);
        for (int i = 0; i < window; i++) {
            if (!comparison.isTrue(chart.getCandle(index - i).getClose(), sma.get(index - i))) {
                return false;
            }
        }
        return true;
    }
}

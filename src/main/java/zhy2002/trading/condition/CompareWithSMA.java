package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class CompareWithSMA implements TradeCondition {

    private final Comparison comparison;
    private final int smaPeriods;

    @Override
    public boolean isMet(Chart chart, int index) {
        var candle = chart.getCandle(index);
        var sma = chart.getSMA(smaPeriods);
        return comparison.isTrue(candle.getClose(), sma.get(index - 1));
    }
}

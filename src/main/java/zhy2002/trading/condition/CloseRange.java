package zhy2002.trading.condition;

import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class CloseRange extends ChartTradeCondition {

    private final double minFactor;
    private final double maxFactor;

    public boolean isMet(Chart chart, int index) {
        Preconditions.checkState(minFactor <= maxFactor);
        var candle = chart.getCandle(index);
        var close = candle.getClose();
        var open = candle.getOpen();
        var max = open * maxFactor;
        var min = open * minFactor;
        return close >= min && close <= max;
    }
}

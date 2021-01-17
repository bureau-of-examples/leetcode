package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

/**
 * EMA(periods) drops at most ratioLimit in the last window days.
 */
@AllArgsConstructor
public class SMAChangeLowerBound extends ChartTradeCondition {

    private final int periods;
    private final int window;
    private final double boundRatio; // normally negative number

    public boolean isMet(Chart chart, int index) {
        var sma = chart.getSMA(periods);
        return (sma.get(index) - sma.get(index - (window - 1))) / sma.get(index - (window - 1)) >= boundRatio;
    }
}

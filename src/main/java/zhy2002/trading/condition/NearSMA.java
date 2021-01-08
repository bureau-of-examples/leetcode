package zhy2002.trading.condition;

import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class NearSMA implements TradeCondition {

    private final int smaPeriods;
    private final double minFactor;
    private final double maxFactor;

    public boolean isMet(Chart chart, int index) {
        Preconditions.checkState(minFactor <= maxFactor);
        var sma = chart.getSMA(smaPeriods);
        var s = sma.get(index);
        var min = s * minFactor;
        var max = s * maxFactor;
        var c = chart.getCandle(index).getClose();
        return c >= min && c <= max;
    }
}

package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

/**
 * Assert in the past, there is an upWindow with average SMA gain >= upRate and before that
 * there is a downWindow with average SMA gain < downRate.
 * SMA gain = (current price - current SMA) / current SMA.
 */
@AllArgsConstructor
public class SMATurn extends ChartTradeCondition {

    private final int smaPeriods;
    private final int downWindow;
    private final int upWindow;
    private final double downRate;
    private final double upRate;

    @Override
    public boolean isMet(Chart chart, int index) {
        var sma = chart.getSMA(smaPeriods);
        double downPercent = 0;
        int downCount = 0;
        for (int i = index - upWindow - downWindow + 1; i <= index - upWindow; i++) {
            var p = (chart.getCandle(i).getClose() - sma.get(i)) / sma.get(i);
            downPercent += p;
            if (p < 0) {
                downCount++;
            }
        }
        downPercent /= downWindow;
        if (downPercent >= downRate) {
            return false;
        }

        double upPercent = 0;
        for (int i = index - upWindow + 1; i <= index; i++) {
            upPercent += (chart.getCandle(i).getClose() - sma.get(i)) / sma.get(i);
        }
        upPercent /= upWindow;
        return upPercent >= upRate;
    }
}

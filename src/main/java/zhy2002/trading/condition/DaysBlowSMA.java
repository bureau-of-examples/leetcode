package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

/**
 * Number of days below SMA / total number of days <= threshold.
 */
@AllArgsConstructor
public class DaysBlowSMA implements TradeCondition {

    private final int periods;
    private final int window;
    private final double threshold;


    public boolean isMet(Chart chart, int index) {
        var sma = chart.getSMA(periods);
        int belowSMACount = 0;
        for (int i = index; i > index - window; i--) {
            if (chart.getCandle(i).getClose() < sma.get(i)) {
                belowSMACount++;
            }
        }

        return ((double) belowSMACount / window) <= threshold;
    }

}

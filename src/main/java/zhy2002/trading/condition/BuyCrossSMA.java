package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class BuyCrossSMA extends ChartTradeCondition {

    private final int smaPeriods;
    private final int proceedingLowers;

    @Override
    public boolean isMet(Chart chart, int index) {
        var ma = chart.getSMA(smaPeriods);
        var candle = chart.getCandle(index);

        // not crossed yet
        if (candle.getClose() <= ma.get(index)) {
            return false;
        }

        // proceeding candles are below ma
        for (int i = 1; i <= proceedingLowers; i++) {
            if (chart.getCandle(index - i).getHigh() >= ma.get(index - i)) {
                return false;
            }
        }
        return true;
    }
}

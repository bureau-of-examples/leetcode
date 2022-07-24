package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class BelowBollingerBand extends ChartTradeCondition {

    private final int belowDays;

    public boolean isMet(Chart chart, int index) {
        var bb = chart.getBollingerBand(15);
        for (int i = 0; i < belowDays; i++) {
            if (chart.getCandle(index - i).getClose() >= bb.getLower(index - i)) {
                return false;
            }
        }
        return true;
    }
}

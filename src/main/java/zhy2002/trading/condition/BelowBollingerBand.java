package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class BelowBollingerBand implements TradeCondition {

    private final int belowDays;

    public boolean isMet(Chart chart, int index) {
        var bb = chart.getBollingerBand();
        if (chart.getCandle(index).getOpen() >= bb.getLower(index - 1)) {
            return false;
        }
        for (int i = 1; i <= belowDays; i++) {
            if (chart.getCandle(index - i).getClose() >= bb.getLower(index - i - 1)) {
                return false;
            }
        }
        return true;
    }

}

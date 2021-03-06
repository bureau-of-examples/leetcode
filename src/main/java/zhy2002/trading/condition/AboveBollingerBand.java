package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;


@AllArgsConstructor
public class AboveBollingerBand extends ChartTradeCondition {

    private final int aboveDays;

    public boolean isMet(Chart chart, int index) {
        var bb = chart.getBollingerBand(15);
        for (int i = 0; i < aboveDays; i++) {
            if (chart.getCandle(index - i).getClose() <= bb.getUpper(index - i)) {
                return false;
            }
        }
        return true;
    }
}

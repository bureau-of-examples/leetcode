package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class CloseAboveSMARate extends ChartTradeCondition {

    private final int periods;
    private final int window;
    private final double minRate;

    public boolean isMet(Chart chart, int index) {
        var abr = chart.getSMAAboveBelowRate(periods, window);
        return abr.getAboveRate(index) >= minRate;
    }
}

package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class CompareWiThRSI implements TradeCondition {

    private final Comparison comparison;
    private final double limit;


    @Override
    public boolean isMet(Chart chart, int index) {
        var rsi = chart.getRSI();
        return comparison.isTrue(rsi.get(index - 1), limit);
    }
}

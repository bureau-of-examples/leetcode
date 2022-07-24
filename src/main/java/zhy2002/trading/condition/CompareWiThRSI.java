package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class CompareWiThRSI extends ChartTradeCondition {

    private final Comparison comparison;
    private final double limit;

    public CompareWiThRSI(Comparison comparison) {
        this(comparison, comparison.defaultRSI());
    }

    @Override
    public boolean isMet(Chart chart, int index) {
        var rsi = chart.getRSI();
        return comparison.isTrue(rsi.get(index), limit);
    }
}

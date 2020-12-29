package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public class SMATrend implements TradeCondition {

    private final Comparison comparison;

    public SMATrend(Comparison comparison) {
        this.comparison = comparison;
    }

    @Override
    public boolean isMet(Chart chart, int index) {
        var sma = chart.getSMA(100);
        return comparison.isTrue(sma.get(index - 1), sma.get(index - 6))
                && comparison.isTrue(sma.get(index - 6), sma.get(index - 11));
    }
}

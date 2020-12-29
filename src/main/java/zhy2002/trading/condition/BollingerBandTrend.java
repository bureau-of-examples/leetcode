package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public class BollingerBandTrend implements TradeCondition {

    private final Comparison comparison;

    public BollingerBandTrend(Comparison comparison) {
        this.comparison = comparison;
    }

    @Override
    public boolean isMet(Chart chart, int index) {
        var bb = chart.getBollingerBand();
        return comparison.isTrue(bb.get(index - 1), bb.get(index - 6))
                && comparison.isTrue(bb.get(index - 6), bb.get(index - 10));
    }
}

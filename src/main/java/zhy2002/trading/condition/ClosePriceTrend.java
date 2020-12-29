package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public class ClosePriceTrend implements TradeCondition {

    private final double threshold;
    private final int periods;
    private final Comparison comparison;

    public ClosePriceTrend(Comparison comparison, double threshold, int periods) {
        this.comparison = comparison;
        this.threshold = threshold;
        this.periods = periods;
    }

    public boolean isMet(Chart chart, int index) {
        double[] values = new double[periods];
        for (int i=0; i<periods; i++) {
            values[i] = chart.getCandle(index - (periods - 1) + i).getClose();
        }
        double k = SMATrend.linearRegressionK(values);
        return comparison.isTrue(k, threshold);
    }

}

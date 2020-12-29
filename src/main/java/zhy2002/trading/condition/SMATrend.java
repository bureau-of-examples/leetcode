package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public class SMATrend implements TradeCondition {

    private final Comparison comparison;
    private final double k;
    private final int smaPeriods;
    private final int window;

    public SMATrend(Comparison comparison, double k, int smaPeriods, int window) {
        this.comparison = comparison;
        this.k = k;
        this.smaPeriods = smaPeriods;
        this.window = window;
    }

    @Override
    public boolean isMet(Chart chart, int index) {
        var sma = chart.getSMA(smaPeriods);
        // linear regression on sma over the last window periods
        double[] values = new double[window];
        for (int i = index - window; i < index; i++) {
            values[i - (index - window)] = sma.get(i);
        }
        return comparison.isTrue(linearRegressionK(values), k);
    }

    // https://www.statisticshowto.com/probability-and-statistics/regression-analysis/find-a-linear-regression-equation/
    static double linearRegressionK(double[] values) {
        double n = values.length;
        double sumX = (n - 1.0) * n / 2;
        double sumX2 = (n - 1.0) * n * (2 * n - 1) / 6;
        double sumY = 0, sumXY = 0;
        for (int i = 0; i < values.length; i++) {
            sumY += values[i];
            sumXY += values[i] * i;
        }
        return (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
    }
}

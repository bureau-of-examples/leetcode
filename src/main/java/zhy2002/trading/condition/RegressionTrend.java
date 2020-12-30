package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.adaptor.ArrayExtractor;

@AllArgsConstructor
public class RegressionTrend implements TradeCondition {

    private final ArrayExtractor extractor;
    private final Comparison comparison;
    private final double k;

    public boolean isMet(Chart chart, int index) {
        double[] values = extractor.extract(chart, index);
        return comparison.isTrue(linearRegressionK(values), k);
    }

    // https://www.statisticshowto.com/probability-and-statistics/regression-analysis/find-a-linear-regression-equation/
    public static double linearRegressionK(double[] values) {
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

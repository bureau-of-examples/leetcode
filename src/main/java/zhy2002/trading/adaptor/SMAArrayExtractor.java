package zhy2002.trading.adaptor;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class SMAArrayExtractor implements ArrayExtractor {

    private final int smaPeriods;
    private final int window;

    public SMAArrayExtractor() {
        this(50, 9);
    }

    @Override
    public double[] extract(Chart chart, int index) {
        var sma = chart.getSMA(smaPeriods);
        // linear regression on sma over the last window periods
        double[] values = new double[window];
        for (int i = index - window + 1; i <= index; i++) {
            values[i - (index - window + 1)] = sma.get(i);
        }
        return values;
    }
}

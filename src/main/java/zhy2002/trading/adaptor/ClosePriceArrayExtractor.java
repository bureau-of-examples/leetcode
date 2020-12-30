package zhy2002.trading.adaptor;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;


@AllArgsConstructor
public class ClosePriceArrayExtractor implements ArrayExtractor {

    private final int window;

    public double[] extract(Chart chart, int index) {
        double[] values = new double[window];
        for (int i = 0; i < window; i++) {
            values[i] = chart.getCandle(index - (window - 1) + i).getClose();
        }
        return values;
    }

}

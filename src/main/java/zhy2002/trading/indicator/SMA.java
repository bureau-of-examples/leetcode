package zhy2002.trading.indicator;


import zhy2002.trading.Chart;
import zhy2002.trading.pricing.ClosePrice;
import zhy2002.trading.pricing.PriceDecider;


public class SMA extends Indicator {

    private final int periods;
    private final PriceDecider priceDecider;
    private final double[] result;

    public SMA(Chart chart, int periods) {
        this(chart, periods, new ClosePrice());
    }

    public SMA(Chart chart, int periods, PriceDecider priceDecider) {
        super(chart);
        this.periods = periods;
        this.priceDecider = priceDecider;

        result = new double[chart.getPeriods() - (periods - 1)];
        double total = 0;
        for (int i = 0; i < chart.getPeriods(); i++) {
            total += priceDecider.decide(chart, i);
            if (i >= periods - 1) {
                result[i - (periods - 1)] = total / periods;
                total -= priceDecider.decide(chart, i - (periods - 1));
            }
        }
    }

    public double get(int i) {
        if (i < periods - 1) {
            throw new IllegalArgumentException("Not data for day index " + i);
        }
        return result[i - (periods - 1)];
    }

}

package zhy2002.trading.indicator;

import com.google.common.base.Preconditions;
import zhy2002.trading.Chart;

public class EMA extends Indicator {

    private static final int WEIGHT = 2;

    private final int periods;
    private final double[] values;


    public EMA(Chart chart, int periods) {
        super(chart);

        this.periods = periods;
        values = new double[chart.getPeriods() - (periods - 1)];

        double total = 0;
        for (int i = 0; i < periods; i++) {
            total += chart.getCandle(i).getClose();
        }
        values[0] = total / periods;

        double multiplier = WEIGHT / (periods + 1.0);
        for (int i = periods; i < chart.getPeriods(); i++) {
            int index = i - (periods - 1);
            values[index] = chart.getCandle(i).getClose() * multiplier + values[index - 1] * (1 - multiplier);
        }
    }

    public double get(int i) {
        Preconditions.checkArgument(i >= periods - 1);
        return values[i - (periods - 1)];
    }
}

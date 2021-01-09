package zhy2002.trading.indicator;

import com.google.common.base.Preconditions;
import zhy2002.trading.Chart;

public class EATR extends Indicator {

    private final int periods;
    private final double[] values;


    public EATR(Chart chart, int periods) {
        super(chart);
        this.periods = periods;

        values = new double[chart.getPeriods() - periods];
        double total = 0;
        for (int i = 1; i <= periods; i++) {
            total += chart.getTr(i);
        }
        values[0] = total / periods;
        for (int i = periods + 1; i < chart.getPeriods(); i++) {
            int index = i - periods;
            values[index] = (values[index - i] * (periods - 1) + chart.getTr(i)) / periods;
        }
    }

    public double get(int i) {
        Preconditions.checkArgument(i >= periods);
        return values[i - periods];
    }

}

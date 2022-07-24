package zhy2002.trading.indicator;

import com.google.common.base.Preconditions;
import zhy2002.trading.Chart;

public class ATR extends Indicator {

    private final int periods;
    private final double[] values;


    public ATR(Chart chart, int periods) {
        super(chart);
        this.periods = periods;

        values = new double[chart.getPeriods() - periods];
        double total = 0;
        for (int i = 1; i < chart.getPeriods(); i++) {
            total += chart.getTr(i);
            if (i >= periods) {
                values[i - periods] = total / periods;
                total -= chart.getTr(i - periods + 1);
            }
        }
    }

    public double get(int i) {
        Preconditions.checkArgument(i >= periods);
        return values[i - periods];
    }


}

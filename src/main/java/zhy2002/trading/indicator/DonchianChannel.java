package zhy2002.trading.indicator;

import com.google.common.base.Preconditions;
import zhy2002.trading.Chart;

import java.util.ArrayDeque;

public class DonchianChannel extends Indicator {

    private final int dcPeriods;
    private final double[] max;
    private final double[] min;

    public DonchianChannel(Chart chart, int dcPeriods) {
        super(chart);

        this.dcPeriods = dcPeriods;
        this.max = new double[chart.getPeriods() - (dcPeriods - 1)];
        this.min = new double[chart.getPeriods() - (dcPeriods - 1)];

        var maxDeque = new ArrayDeque<Double>();//big to small
        var minDeque = new ArrayDeque<Double>();//small to big
        for (int i = 0; i < chart.getPeriods(); i++) {
            var c = chart.getCandle(i).getClose();
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < c) {
                maxDeque.pollLast();
            }
            maxDeque.add(c);

            while (!minDeque.isEmpty() && minDeque.peekLast() > c) {
                minDeque.pollLast();
            }
            minDeque.add(c);

            if (i >= dcPeriods - 1) {
                var oldC = chart.getCandle(i - (dcPeriods - 1)).getClose();

                max[i - (dcPeriods - 1)] = maxDeque.getFirst();
                if (oldC == maxDeque.getFirst()) {
                    maxDeque.pollFirst();
                }

                min[i - (dcPeriods - 1)] = minDeque.getFirst();
                if (oldC == minDeque.getFirst()) {
                    minDeque.pollFirst();
                }
            }
        }
    }

    public double get(int i) {
        Preconditions.checkArgument(i >= dcPeriods - 1);
        return (getUpper(i) + getLower(i)) / 2.0;
    }

    public double getUpper(int i) {
        Preconditions.checkArgument(i >= dcPeriods - 1);
        return max[i - (dcPeriods - 1)];
    }

    public double getLower(int i) {
        Preconditions.checkArgument(i >= dcPeriods - 1);
        return min[i - (dcPeriods - 1)];
    }
}

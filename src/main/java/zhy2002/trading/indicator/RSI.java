package zhy2002.trading.indicator;

import zhy2002.trading.Chart;

public class RSI extends Indicator {

    private final int periods;
    private final double[] values;

    public RSI(Chart chart, int periods) {
        super(chart);

        this.periods = periods;
        values = new double[chart.getPeriods() - periods];
        double totalGain = 0;
        double totalLoss = 0;
        for (int i = 1; i <= periods; i++) {
            double diff = getDiff(i);
            if (diff > 0) {
                totalGain += diff;
            } else {
                totalLoss -= diff;
            }
        }
        values[0] = 100 - 100.0 / (1.0 + totalGain / totalLoss);
        for (int i = periods + 1; i < chart.getPeriods(); i++) {
            double diff = getDiff(i);
            if (diff > 0) {
                totalGain = totalGain * (periods - 1) / periods + diff;
                totalLoss = totalLoss * (periods - 1) / periods;
            } else {
                totalGain = totalGain * (periods - 1) / periods;
                totalLoss = totalLoss * (periods - 1) / periods - diff;
            }
            values[i - periods] = 100 - 100.0 / (1.0 + totalGain / totalLoss);
        }
    }

    private double getDiff(int i) {
        var previous = getChart().getCandle(i - 1);
        var current = getChart().getCandle(i);
        return current.getClose() - previous.getClose();
    }

    public double get(int i) {
        if (i < periods) {
            throw new IllegalArgumentException("Invalid index " + i);
        }
        return values[i - periods];
    }
}

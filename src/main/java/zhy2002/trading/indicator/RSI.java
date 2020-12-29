package zhy2002.trading.indicator;

import zhy2002.trading.Chart;

public class RSI extends Indicator {

    private final int rsiPeriods;
    private final double result[];

    public RSI(Chart chart, int rsiPeriods) {
        super(chart);

        this.rsiPeriods = rsiPeriods;
        result = new double[chart.getPeriods() - rsiPeriods];
        double totalGain = 0;
        double totalLoss = 0;
        for (int i = 1; i <= rsiPeriods; i++) {
            double diff = getDiff(i);
            if (diff > 0) {
                totalGain += diff;
            } else {
                totalLoss -= diff;
            }
        }
        result[0] = 100 - 100.0 / (1.0 + totalGain / totalLoss);
        for (int i = rsiPeriods + 1; i < chart.getPeriods(); i++) {
            double diff = getDiff(i);
            if (diff > 0) {
                totalGain = totalGain * (rsiPeriods - 1) / rsiPeriods + diff;
                totalLoss = totalLoss * (rsiPeriods - 1) / rsiPeriods;
            } else {
                totalGain = totalGain * (rsiPeriods - 1) / rsiPeriods;
                totalLoss = totalLoss * (rsiPeriods - 1) / rsiPeriods - diff;
            }
            result[i - rsiPeriods] = 100 - 100.0 / (1.0 + totalGain / totalLoss);
        }
    }

    private double getDiff(int i) {
        var previous = getChart().getCandle(i - 1);
        var current = getChart().getCandle(i);
        return current.getClose() - previous.getClose();
    }

    public double get(int i) {
        if (i < rsiPeriods) {
            throw new IllegalArgumentException("Invalid index " + i);
        }
        return result[i - rsiPeriods];
    }
}

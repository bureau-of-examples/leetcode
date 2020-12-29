package zhy2002.trading.indicator;

import zhy2002.trading.Chart;

//https://www.investopedia.com/terms/b/bollingerbands.asp
public class BollingerBand extends Indicator {

    private static final int M = 2;

    private final int bbPeriods;

    private final double[] upper;
    private final double[] lower;

    public BollingerBand(Chart chart, int bbPeriods) {
        super(chart);

        this.bbPeriods = bbPeriods;
        upper = new double[chart.getPeriods() - (bbPeriods - 1)];
        lower = new double[chart.getPeriods() - (bbPeriods - 1)];
        double totalTp = 0;
        for (int i = 0; i < bbPeriods - 1; i++) {
            totalTp += getTp(i);
        }
        for (int i = bbPeriods - 1; i < chart.getPeriods(); i++) {
            totalTp += getTp(i);
            double mean = totalTp / bbPeriods;
            double d2 = 0;
            for (int j = 0; j < bbPeriods; j++) {
                double diff = getTp(i - j) - mean;
                d2 += diff * diff;
            }
            double d = Math.sqrt(d2 / bbPeriods);
            upper[i - (bbPeriods - 1)] = mean + M * d;
            lower[i - (bbPeriods - 1)] = mean - M * d;
            totalTp -= getTp(i - (bbPeriods - 1));
        }
    }

    private double getTp(int i) {
        return getChart().getCandle(i).getTp();
    }

    public double getUpper(int i) {
        if (i < bbPeriods - 1) {
            throw new IllegalArgumentException("Invalid index " + i);
        }
        return upper[i - (bbPeriods - 1)];
    }

    public double getLower(int i) {
        if (i < bbPeriods - 1) {
            throw new IllegalArgumentException("Invalid index " + i);
        }
        return lower[i - (bbPeriods - 1)];
    }

    public double get(int i) {
        return (getUpper(i) + getLower(i)) / 2;
    }
}

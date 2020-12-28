package zhy2002.trading.indicator;

import zhy2002.trading.Chart;

public class ATR extends Indicator {

    private final int periods;
    private final double[] result;


    public ATR(Chart chart, int periods) {
        super(chart);
        this.periods = periods;

        result = new double[chart.getPeriods() - periods];
        double total = 0;
        for (int i = 1; i < chart.getPeriods(); i++) {
            total += getTr(chart, i);
            if (i >= periods) {
                result[i - periods] = total / periods;
                total -= getTr(chart, i - periods + 1);
            }
        }
    }

    private double getTr(Chart chart, int i) {
        var current = chart.getCandle(i);
        var previous = chart.getCandle(i - 1);
        return Math.max(
                Math.max(current.getHigh() - current.getLow(), Math.abs(current.getHigh() - previous.getClose())),
                Math.abs(current.getLow() - previous.getClose()));
    }

    public double get(int i) {
        if (i < periods) {
            throw new IllegalArgumentException("Not data for day index " + i);
        }
        return result[i - periods];
    }


}

package zhy2002.trading.indicator;

import zhy2002.trading.Candle;

import java.util.List;

public class MA {

    private final int periods;
    private double[] result;

    public MA(int periods) {
        this.periods = periods;
    }

    public void compute(List<Candle> candles) {
        result = new double[candles.size()];
        double total = 0;
        for (int i = 0; i < candles.size(); i++) {
            total += candles.get(i).close;
            if (i >= periods) {
                total -= candles.get(i - periods).close;
                result[i] = total / periods;
            }
        }
    }

    public double get(int i) {
        return result[i];
    }

    public int getPeriods() {
        return periods;
    }

}

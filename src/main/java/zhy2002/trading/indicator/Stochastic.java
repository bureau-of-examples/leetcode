package zhy2002.trading.indicator;

import zhy2002.trading.Chart;
import zhy2002.trading.data.MovingAverageProvider;
import zhy2002.trading.data.StochasticKProvider;
import zhy2002.trading.data.ValueProvider;

public class Stochastic extends Indicator {

    private final int periods;
    private final ValueProvider kProvider;
    private final ValueProvider dProvider;

    public Stochastic(Chart chart, int periods, int kSmooth, int dSmooth) {
        super(chart);

        this.periods = periods;
        var originalK = new StochasticKProvider(chart, periods);
        this.kProvider = kSmooth == 1 ? originalK : new MovingAverageProvider(originalK, kSmooth);
        this.dProvider = dSmooth == 1 ? kProvider : new MovingAverageProvider(kProvider, dSmooth);
    }

    public double getK(int i) {
        return kProvider.get(i);
    }

    public double getD(int i) {
        return dProvider.get(i);
    }
}

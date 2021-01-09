package zhy2002.trading.indicator;

import com.google.common.base.Preconditions;
import zhy2002.trading.Chart;
import zhy2002.trading.data.RollingMaxProvider;
import zhy2002.trading.data.RollingMinProvider;

public class DonchianChannel extends Indicator {

    private final int periods;
    private final RollingMaxProvider maxProvider;
    private final RollingMinProvider minProvider;

    public DonchianChannel(Chart chart, int periods) {
        super(chart);

        this.periods = periods;
        maxProvider = new RollingMaxProvider(chart.getClosePriceProvider(), periods);
        minProvider = new RollingMinProvider(chart.getClosePriceProvider(), periods);
    }

    public double get(int i) {
        Preconditions.checkArgument(i >= periods - 1);
        return (getUpper(i) + getLower(i)) / 2.0;
    }

    public double getUpper(int i) {
        return maxProvider.get(i);
    }

    public double getLower(int i) {
        return minProvider.get(i);
    }
}

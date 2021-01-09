package zhy2002.trading.data;

import zhy2002.trading.Chart;


public class StochasticKProvider implements ValueProvider {

    private final Chart chart;
    private final ValueProvider maxProvider;
    private final ValueProvider minProvider;


    public StochasticKProvider(Chart chart, int window) {
        this.chart = chart;
        this.maxProvider = new RollingMaxProvider(chart.getHighPriceProvider(), window);
        this.minProvider = new RollingMinProvider(chart.getLowPriceProvider(), window);
    }

    @Override
    public double get(int i) {
        return (chart.getCandle(i).getClose() - minProvider.get(i)) / (maxProvider.get(i) - minProvider.get(i)) * 100.0;
    }

    @Override
    public int length() {
        return chart.getPeriods();
    }

    @Override
    public int getStartIndex() {
        return this.maxProvider.getStartIndex();
    }
}

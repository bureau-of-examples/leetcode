package zhy2002.trading.indicator;

import zhy2002.trading.Chart;

public abstract class Indicator {

    private final Chart chart;

    public Indicator(Chart chart) {
        this.chart = chart;
    }

    public Chart getChart() {
        return chart;
    }
}

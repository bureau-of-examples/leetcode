package zhy2002.trading.pricing;

import zhy2002.trading.Chart;

public interface PriceDecider {
    double decide(Chart chart, int index);
}

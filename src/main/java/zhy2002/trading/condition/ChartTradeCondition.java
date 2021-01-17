package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.Trade;

/**
 * A trade condition that only depends on the chart.
 */
public abstract class ChartTradeCondition implements TradeCondition {

    public final boolean isMet(Trade trade, Chart chart, int index) {
        return isMet(chart, index);
    }

    public abstract boolean isMet(Chart chart, int index);
}

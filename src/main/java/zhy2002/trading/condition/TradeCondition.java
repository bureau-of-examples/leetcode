package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.Trade;

/**
 * TradeCondition only depends on the chart and a given trade.
 * Trade parameter is set iff we are evaluating a sell condition.
 */
public interface TradeCondition {

    boolean isMet(Trade trade, Chart chart, int index);

}

package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.Trader;

public interface TradeCondition {
    default boolean isMet(Trader trader, Chart chart, int index) {
        return isMet(chart, index);
    }

    default boolean isMet(Chart chart, int index) {
        return false;
    }
}

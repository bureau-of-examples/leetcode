package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.Trade;

public class Not implements TradeCondition {

    private final TradeCondition inner;

    public Not(TradeCondition inner) {
        this.inner = inner;
    }

    public boolean isMet(Trade trade, Chart chart, int index) {
        return !inner.isMet(trade, chart, index);
    }
}

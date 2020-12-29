package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.Trader;

public class Not implements TradeCondition {

    private final TradeCondition inner;

    public Not(TradeCondition inner) {
        this.inner = inner;
    }

    public boolean isMet(Trader trader, Chart chart, int index) {
        return !inner.isMet(trader, chart, index);
    }
}

package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.trading.Trader;

public class And implements TradeCondition {

    private final TradeCondition[] conditions;

    public And(TradeCondition... conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean isMet(Trader trader, Chart chart, int index) {
        for (var c : conditions) {
            if (!c.isMet(trader, chart, index)) {
                return false;
            }
        }
        return true;
    }
}

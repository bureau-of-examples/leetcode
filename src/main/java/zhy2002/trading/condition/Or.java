package zhy2002.trading.condition;

import zhy2002.trading.Trader;

public class Or implements TradeCondition {

    private final TradeCondition[] conditions;

    public Or(TradeCondition... conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean isMet(Trader trader, int index) {
        for (var c : conditions) {
            if (c.isMet(trader, index)) {
                return true;
            }
        }
        return false;
    }
}

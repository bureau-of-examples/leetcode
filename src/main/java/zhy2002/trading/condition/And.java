package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public class And implements TradeCondition {

    private final TradeCondition[] conditions;

    public And(TradeCondition... conditions) {
        this.conditions = conditions;
    }

    @Override
    public boolean isMet(Chart chart, int index) {
        for (var c : conditions) {
            if (!c.isMet(chart, index)) {
                return false;
            }
        }
        return true;
    }
}

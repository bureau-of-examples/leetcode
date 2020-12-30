package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.Trader;

/**
 * Shift the inner condition to the left for N days.
 */
@AllArgsConstructor
public class ShiftLeft implements TradeCondition {

    // by default shift left for 1 day.
    public ShiftLeft(TradeCondition inner) {
        this(inner, 1);
    }

    private final TradeCondition inner;
    private final int offset;

    public boolean isMet(Trader trader, Chart chart, int index) {
        return inner.isMet(trader, chart, index - offset);
    }
}

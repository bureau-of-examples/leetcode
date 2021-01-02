package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.trading.Trader;

@AllArgsConstructor
public class HoldAfterDays implements TradeCondition {

    private final int days;

    public boolean isMet(Trader trader, Chart chart, int index) {
        return index - trader.getCurrentTrade().getBuyDayIndex() >= days;
    }
}

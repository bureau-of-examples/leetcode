package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.Trade;

@AllArgsConstructor
public class HoldAfterDays implements TradeCondition {

    private final int days;

    @Override
    public boolean isMet(Trade trade, Chart chart, int index) {
        return index - trade.getBuyDayIndex() >= days;
    }
}

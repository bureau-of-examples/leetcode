package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.Trade;

@AllArgsConstructor
public class TakeProfit implements TradeCondition {

    private final double percent;

    @Override
    public boolean isMet(Trade trade, Chart chart, int index) {
        return chart.getCandle(index).getClose() / trade.getBuyPrice() >= (1 + percent);
    }
}

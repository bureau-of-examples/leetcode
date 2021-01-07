package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.trading.Trader;

@AllArgsConstructor
public class TakeProfit implements TradeCondition {

    private final double percent;

    public boolean isMet(Trader trader, Chart chart, int index) {
        var trade = trader.getCurrentTrade();
        return chart.getCandle(index).getClose() / trade.getBuyPrice() >= (1 + percent);
    }
}

package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.trading.Trader;

@AllArgsConstructor
public class TrailingStopLoss implements TradeCondition {

    private final double percent;
    private final int maxHoldDays;

    @Override
    public boolean isMet(Trader trader, Chart chart, int index) {
        var trade = trader.getCurrentTrade();
        var holdDays = index - trade.getBuyDayIndex();
        if (holdDays > maxHoldDays) {
            return false;
        }
        var threshold = percent * trade.getMaxPrice();
        var candle = chart.getCandle(index);
        return candle.getClose() <= threshold;

    }
}

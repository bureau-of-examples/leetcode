package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.trading.Trader;

public class CandleCross2 implements TradeCondition {

    public boolean isMet(Trader trader, Chart chart, int index) {
        var trade = trader.getCurrentTrade();
        var atr = chart.getATR();
        var candle = chart.getCandle(index);
        return candle.getClose() <= trade.getMaxPrice() - atr.get(index) * 3;
    }
}

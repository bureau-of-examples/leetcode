package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.Trade;

public class CandleCross2 implements TradeCondition {

    @Override
    public boolean isMet(Trade trade, Chart chart, int index) {
        var atr = chart.getATR();
        var candle = chart.getCandle(index);
        return candle.getClose() <= trade.getMaxPrice() - atr.get(index) * 3;
    }
}

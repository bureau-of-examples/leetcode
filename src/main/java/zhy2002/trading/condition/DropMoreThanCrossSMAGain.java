package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.Trade;

public class DropMoreThanCrossSMAGain implements TradeCondition {

    @Override
    public boolean isMet(Trade trade, Chart chart, int index) {
        var buyCandle = chart.getCandle(trade.getBuyDayIndex());
        double min = buyCandle.getClose();
        for (int i = 1; i <= 3; i++) {
            var candle = chart.getCandle(trade.getBuyDayIndex() - i);
            min = Math.min(min, candle.getClose());
        }
        double diff = buyCandle.getClose() - min;
        return trade.getMaxPrice() - chart.getCandle(index).getClose() >= diff;
    }
}

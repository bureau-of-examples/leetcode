package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.Trade;

public class StopLoss implements TradeCondition {

    private final double percent;

    public StopLoss(double percent) {
        this.percent = percent;
    }

    @Override
    public boolean isMet(Trade trade, Chart chart, int index) {
        if (trade == null) {
            return false;
        }
        return trade.getChart().getCandle(index).getClose() < trade.getBuyPrice() * percent;
    }
}

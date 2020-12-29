package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.Trader;

public class StopLoss implements TradeCondition {

    private final double percent;

    public StopLoss(double percent) {
        this.percent = percent;
    }

    @Override
    public boolean isMet(Trader trader, Chart chart, int index) {
        if (trader.getCurrentTrade() == null) {
            return false;
        }
        return trader.getCurrentTrade().getChart().getCandle(index).getClose() < trader.getCurrentTrade().getBuyPrice() * percent;
    }
}

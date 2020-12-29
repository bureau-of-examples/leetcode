package zhy2002.trading.condition;

import zhy2002.trading.Trader;

public class StopLoss implements TradeCondition {

    private final double percent;

    public StopLoss(double percent) {
        this.percent = percent;
    }


    @Override
    public boolean isMet(Trader trader, int index) {
        if (trader.getCurrentTrade() == null) {
            return false;
        }
        return trader.getChart().getCandle(index).getClose() < trader.getCurrentTrade().getBuyPrice() * percent;
    }
}

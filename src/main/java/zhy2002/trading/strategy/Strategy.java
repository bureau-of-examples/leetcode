package zhy2002.trading.strategy;

import zhy2002.trading.Chart;
import zhy2002.trading.condition.TradeCondition;
import zhy2002.trading.pricing.ClosePrice;
import zhy2002.trading.pricing.PriceDecider;


public class Strategy {

    private final TradeCondition tradeCondition;
    private final PriceDecider priceDecider;

    public Strategy(TradeCondition tradeCondition) {
        this(tradeCondition, new ClosePrice());
    }

    public Strategy(TradeCondition tradeCondition, PriceDecider priceDecider) {
        this.tradeCondition = tradeCondition;
        this.priceDecider = priceDecider;
    }

    public boolean shouldTakeAction(Chart chart, int index) {
        return tradeCondition.isMet(chart, index);
    }

    public double decidePrice(Chart chart, int index) {
        return priceDecider.decide(chart, index);
    }
}

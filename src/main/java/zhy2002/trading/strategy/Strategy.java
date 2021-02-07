package zhy2002.trading.strategy;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.Trade;
import zhy2002.trading.condition.TradeCondition;
import zhy2002.trading.pricing.ClosePrice;
import zhy2002.trading.pricing.PriceDecider;

@AllArgsConstructor
public final class Strategy {

    private final String name;
    private final TradeCondition tradeCondition;
    private final PriceDecider priceDecider;

    public Strategy(String name, TradeCondition tradeCondition) {
        this(name, tradeCondition, new ClosePrice());
    }

    public boolean shouldTakeAction(Trade currentTrade, Chart chart, int index) {
        return tradeCondition.isMet(currentTrade, chart, index);
    }

    // decide the highest buy price or lowest sell price for the day
    public double decidePrice(Chart chart, int index) {
        return priceDecider.decide(chart, index);
    }

    @Override
    public String toString() {
        return name;
    }
}

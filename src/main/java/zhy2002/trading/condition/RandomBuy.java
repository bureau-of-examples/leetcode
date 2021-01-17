package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.Trade;

import java.util.Random;

@AllArgsConstructor
public class RandomBuy implements TradeCondition {

    private final Random rand;
    private final double buyProbability;

    @Override
    public boolean isMet(Trade trade, Chart chart, int index) {
        return rand.nextDouble() < buyProbability;
    }
}

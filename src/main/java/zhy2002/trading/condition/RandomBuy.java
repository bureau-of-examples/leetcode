package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.trading.Trader;

import java.util.Random;

@AllArgsConstructor
public class RandomBuy implements TradeCondition {

    private final Random rand;
    private final double buyProbability;

    @Override
    public boolean isMet(Trader trader, Chart chart, int index) {
        return rand.nextDouble() < buyProbability;
    }
}

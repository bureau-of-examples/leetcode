package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.Trade;
import zhy2002.trading.trading.Trader;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@AllArgsConstructor
public class RandomSell implements TradeCondition {

    private final Random rand;
    private final int minHoldDays;
    private final int maxHoldDays;

    private final Map<Trade, Integer> cache = new HashMap<>();

    @Override
    public boolean isMet(Trader trader, Chart chart, int index) {
        int sellDay = cache.computeIfAbsent(trader.getCurrentTrade(), t -> minHoldDays + rand.nextInt(maxHoldDays - minHoldDays + 1));
        if (index == trader.getCurrentTrade().getBuyDayIndex() + sellDay) {
            cache.remove(trader.getCurrentTrade());
            return true;
        }
        return false;
    }
}

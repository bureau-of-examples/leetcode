package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.Trade;

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
    public boolean isMet(Trade trade, Chart chart, int index) {
        int sellDay = cache.computeIfAbsent(trade, t -> minHoldDays + rand.nextInt(maxHoldDays - minHoldDays + 1));
        if (index == trade.getBuyDayIndex() + sellDay) {
            cache.remove(trade);
            return true;
        }
        return false;
    }
}

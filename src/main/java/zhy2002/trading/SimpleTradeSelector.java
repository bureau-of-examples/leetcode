package zhy2002.trading;

import lombok.AllArgsConstructor;
import zhy2002.trading.trading.Trader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SimpleTradeSelector {

    private final List<Trader> traders;
    private final int cooldownDays;

    public List<Trade> selectTrades() {
        var previousTradeMap = new HashMap<Trade, Trade>();
        for (var trader : traders) {
            for (int i = 1; i < trader.getTrades().size(); i++) {
                previousTradeMap.put(trader.getTrades().get(i), trader.getTrades().get(i - 1));
            }
        }

        var allTrades = traders.stream().flatMap(trader -> trader.getTrades().stream()).sorted(Comparator.comparingInt(Trade::getBuyDayIndex)).collect(Collectors.toList());
        var selected = new ArrayList<Trade>();
        for (var t : allTrades) {
            if (selected.isEmpty()) {
                selected.add(t);
            } else {
                var lastTrade = selected.get(selected.size() - 1);
                if (lastTrade.getSellDayIndex() == -1) {
                    break;
                } else {
                    if (t.getBuyDayIndex() <= lastTrade.getSellDayIndex()) {
                        continue;
                    }

                    // previous trade no good, cool down applies
                    var prevT = previousTradeMap.get(t);
                    if (prevT != null && prevT.getBuyPrice() >= prevT.getSellPrice() && t.getBuyDayIndex() <= prevT.getSellDayIndex() + cooldownDays) {
                        continue;
                    }

                    selected.add(t);
                }
            }
        }
        return selected;
    }

}

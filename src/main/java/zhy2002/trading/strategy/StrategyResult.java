package zhy2002.trading.strategy;

import lombok.Getter;
import zhy2002.trading.StockGroup;
import zhy2002.trading.Trade;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategyResult {

    @Getter
    private final StockGroup stockGroup;
    @Getter
    private final StrategyPair strategyPair;

    private final Map<String, List<Trade>> tradesMap = new HashMap<>();

    public StrategyResult(StockGroup sg, StrategyPair sp) {
        this.stockGroup = sg;
        this.strategyPair = sp;
    }

    public void putTrades(String s, List<Trade> trades) {
        tradesMap.put(s, trades);
    }

    public List<Trade> getTrades(String symbol) {
        return Collections.unmodifiableList(tradesMap.get(symbol));
    }


}

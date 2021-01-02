package zhy2002.trading.strategy;

import lombok.Getter;
import zhy2002.trading.StockGroup;
import zhy2002.trading.Trade;
import zhy2002.trading.trading.Trader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategyResult {

    @Getter
    private final StockGroup stockGroup;
    @Getter
    private final StrategyPair strategyPair;

    private final Map<String, Trader> traderMap = new HashMap<>();

    public StrategyResult(StockGroup sg, StrategyPair sp) {
        this.stockGroup = sg;
        this.strategyPair = sp;
    }

    public void putTrader(String s, Trader trader) {
        traderMap.put(s, trader);
    }

    public Trader getTrader(String symbol) {
        return traderMap.get(symbol);
    }

    public List<Trade> getTrades(String symbol) {
        return getTrader(symbol).getTrades();
    }
}

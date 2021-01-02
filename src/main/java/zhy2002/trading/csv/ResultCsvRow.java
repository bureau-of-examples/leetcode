package zhy2002.trading.csv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import zhy2002.trading.strategy.Strategy;
import zhy2002.trading.strategy.StrategyPair;
import zhy2002.trading.trading.TradeStatistics;

import java.util.Map;
import java.util.TreeMap;

@AllArgsConstructor
@Getter
public class ResultCsvRow {

    private final String group;
    private final String symbol;
    private final StrategyPair strategyPair;
    private final Map<Integer, TradeStatistics> statsByYear = new TreeMap<>();

    public Strategy getBuyStrategy() {
        return strategyPair.getBuyStrategy();
    }

    public Strategy getSellStrategy() {
        return strategyPair.getSellStrategy();
    }

    public void putStats(int year, TradeStatistics stats) {
        statsByYear.put(year, stats);
    }

    public Object getData(int year, String colName) {
        return statsByYear.get(year).getData(colName);
    }
}

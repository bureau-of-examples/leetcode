package zhy2002.trading.csv;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import zhy2002.trading.Trade;
import zhy2002.trading.strategy.Strategy;
import zhy2002.trading.strategy.StrategyPair;
import zhy2002.trading.trading.TradeStatistics;
import zhy2002.trading.trading.Trader;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class ResultCsvRow {

    private static final TradeStatistics NO_TRADE_STATS = new TradeStatistics(Collections.emptyList());

    @Getter
    private final String group;
    @Getter
    private final String symbol;
    private final StrategyPair strategyPair;
    private final Trader trader;
    private final TradeStatistics overallStats;
    private final Map<Integer, TradeStatistics> statsByYear = new TreeMap<>();

    public ResultCsvRow(String group, String symbol, StrategyPair strategyPair, Trader trader) {
        this.group = group;
        this.symbol = symbol;
        this.strategyPair = strategyPair;
        this.trader = trader;
        this.overallStats = new TradeStatistics(trader.getCompletedTrades());

        Multimap<String, Trade> yearTrades = partitionByYear(trader.getTrades());
        assert yearTrades.keySet().size() < 100;
        for (String key : yearTrades.keySet()) {
            statsByYear.put(Integer.valueOf(key), new TradeStatistics(yearTrades.get(key)));
        }
    }

    @NotNull
    private static Multimap<String, Trade> partitionByYear(List<Trade> trades) {
        Multimap<String, Trade> yearTrades = ArrayListMultimap.create();
        for (var t : trades) {
            yearTrades.put(t.getChart().getCandle(t.getBuyDayIndex()).getDate().substring(0, 4), t);
        }
        return yearTrades;
    }

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
        var stats = statsByYear.get(year);
        if (stats == null) {
            stats = NO_TRADE_STATS;
        }
        return stats.getData(colName);
    }

    public TradeStatistics getOverallStats() {
        return this.overallStats;
    }

    public double getLastFund() {
        return trader.lastFund();
    }
}

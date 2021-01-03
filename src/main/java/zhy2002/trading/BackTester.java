package zhy2002.trading;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.jetbrains.annotations.NotNull;
import zhy2002.trading.csv.ResultCsv;
import zhy2002.trading.csv.ResultCsvRow;
import zhy2002.trading.strategy.StrategyPair;
import zhy2002.trading.strategy.StrategyResult;
import zhy2002.trading.test.BackTestSetup;
import zhy2002.trading.test.BollingerBandSetup;
import zhy2002.trading.test.RandomSetup;
import zhy2002.trading.trading.TradeStatistics;
import zhy2002.trading.trading.Trader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Tests all given strategies and save results to a csv file for screening.
 * Once a strategy is selected, we need to further test it (including parameters) to avoid over fitting (todo):
 * 1. consistent performance in most years
 * 2. performance is irrelevant to start date
 * 3. consistent performance for similar stocks
 * 4. similar performance for similar parameter range
 */
public class BackTester {

    private static final String START_DATE = "2007-01-01";
    private static final double START_FUND = 10_000;
    private static final int START_YEAR = 2007;
    private static final int END_YEAR = 2020;

    public static void main(String[] args) {
        //var setup = new SMAWithMovementSetup();
        var setup = new BollingerBandSetup();
        //var setup = new RandomSetup();
        var tester = new BackTester();
        tester.backTest(setup, START_DATE);
    }

    /**
     * @param setup     provides the stocks and strategy pairs to test.
     * @param startDate between "2006-11-16" and "2007-01-31"
     */
    public void backTest(BackTestSetup setup, String startDate) {
        List<StockGroup> stockGroups = setup.createStockGroups();
        var strategyPairs = setup.createStrategyPairs();
        var tradeResultMap = backTest(stockGroups, strategyPairs, startDate);
        saveStrategyResults(setup.getClass().getSimpleName(), tradeResultMap);
    }

    /**
     * One result for each combination of stock group and strategy pair.
     * Result key is stock group name.
     */
    private static Map<String, List<StrategyResult>> backTest(
            List<StockGroup> stockGroups, List<StrategyPair> strategyPairs, String startDate) {
        Map<String, List<StrategyResult>> result = new HashMap<>();
        var chartMap = new HashMap<String, Chart>();
        for (var group : stockGroups) {
            var groupName = group.getName();
            result.put(groupName, new ArrayList<>());
            for (var pair : strategyPairs) {
                var spResult = new StrategyResult(group, pair);
                for (var s : group.getSymbols()) {
                    var chart = chartMap.computeIfAbsent(s, Chart::new);
                    Trader trader = new Trader(chart, pair);
                    int startIndex = chart.findDateIndex(startDate);
                    trader.trade(START_FUND, startIndex);
                    spResult.putTrader(s, trader);
                }
                result.get(groupName).add(spResult);
            }
        }
        return result;
    }

    private static void saveStrategyResults(String fileName, Map<String, List<StrategyResult>> tradeResultMap) {
        var rows = new ArrayList<ResultCsvRow>();
        for (var entry : tradeResultMap.entrySet()) {
            var groupName = entry.getKey();
            var strategyResultList = entry.getValue();
            for (var strategyResult : strategyResultList) {
                for (var symbol : strategyResult.getStockGroup().getSymbols()) {
                    var trader = strategyResult.getTrader(symbol);
                    Multimap<String, Trade> yearTrades = partitionByYear(trader.getTrades());
                    var row = new ResultCsvRow(groupName, symbol, strategyResult.getStrategyPair(), trader.lastFund());
                    for (int year = START_YEAR; year <= END_YEAR; year++) {
                        row.putStats(year, new TradeStatistics(yearTrades.get(String.valueOf(year))));
                    }
                    rows.add(row);
                }
            }
        }
        var resultCsv = new ResultCsv(START_YEAR, END_YEAR, rows);
        resultCsv.writeToFile(fileName);
    }

    @NotNull
    private static Multimap<String, Trade> partitionByYear(List<Trade> trades) {
        Multimap<String, Trade> yearTrades = ArrayListMultimap.create();
        for (var t : trades) {
            yearTrades.put(t.getChart().getCandle(t.getBuyDayIndex()).getDate().substring(0, 4), t);
        }
        return yearTrades;
    }
}

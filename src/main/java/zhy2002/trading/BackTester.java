package zhy2002.trading;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.jetbrains.annotations.NotNull;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.ConsecutiveMovement;
import zhy2002.trading.csv.ResultCsv;
import zhy2002.trading.csv.ResultCsvRow;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;
import zhy2002.trading.strategy.StrategyResult;
import zhy2002.trading.trading.TradeGenerator;
import zhy2002.trading.trading.TradeStatistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Avoid over fitting:
 * 1. consistent performance through time (selection)
 * 2. consistent performance on similar stocks (selection)
 * 3. similar performance for similar parameter range (verification)
 */
public class BackTester {

    private static final String START_DATE = "2007-01-01";
    private static final int START_YEAR = 2007;
    private static final int END_YEAR = 2020;

    public static void main(String[] args) {
        List<StockGroup> stockGroups = createStockGroups();
        var strategyPairs = createStrategyPairs();
        var tradeResultMap = backTest(stockGroups, strategyPairs);
        saveStrategyResults(tradeResultMap);

        // todo evaluate parameter stability for selected strategy
    }

    private static void addStrategyPairs(ArrayList<StrategyPair> result, StrategyGeneratorV2 buys, StrategyGeneratorV2 sells) {
        for (var b : buys) {
            for (var s : sells) {
                result.add(new StrategyPair(b, s));
            }
            sells.reset();
        }
    }

    private static List<StockGroup> createStockGroups() {
        return List.of(
                new StockGroup("AU-FIN", List.of("CBA.AX", "NAB.AX")),
                new StockGroup("AU-MAT", List.of("BHP.AX", "RIO.AX"))
        );
    }

    private static List<StrategyPair> createStrategyPairs() {
        var result = new ArrayList<StrategyPair>();

        // position then reversal
        var buySMAWithMovement = new StrategyGeneratorV2(
                "BelowSMA+Movement",
                new ParameterCrossProduct()
                        .withParameter("smaPeriods", new int[]{20, 50, 100, 200})
                        .withParameter("times", new int[]{2, 3, 4}),
                ps -> new And(
                        new CompareWithSMA(Comparison.LOWER, ps.getInt("smaPeriods")),
                        new ConsecutiveMovement(Comparison.HIGHER, ps.getInt("times"))
                ));
        var sellSMAWithMovement = new StrategyGeneratorV2(
                "AboveSMA+Movement",
                new ParameterCrossProduct()
                        .withParameter("smaPeriods", new int[]{20, 50, 100, 200})
                        .withParameter("times", new int[]{2, 3, 4}),
                ps -> new And(
                        new CompareWithSMA(Comparison.HIGHER, ps.getInt("smaPeriods")),
                        new ConsecutiveMovement(Comparison.LOWER, ps.getInt("times"))
                ));

        addStrategyPairs(result, buySMAWithMovement, sellSMAWithMovement);
        return result;
    }

    /**
     * One result for each combination of stock group and strategy pair.
     * Result key is stock group name.
     */
    private static Map<String, List<StrategyResult>> backTest(
            List<StockGroup> stockGroups, List<StrategyPair> strategyPairs) {
        Map<String, List<StrategyResult>> result = new HashMap<>();
        var tradeGenerator = new TradeGenerator();
        var chartMap = new HashMap<String, Chart>();
        for (var group : stockGroups) {
            var groupName = group.getName();
            result.put(groupName, new ArrayList<>());
            for (var pair : strategyPairs) {
                var spResult = new StrategyResult(group, pair);
                for (var s : group.getSymbols()) {
                    var chart = chartMap.computeIfAbsent(s, Chart::new);
                    var trades = tradeGenerator.generate(chart, pair, START_DATE);
                    spResult.putTrades(s, trades);
                }
                result.get(groupName).add(spResult);
            }
        }
        return result;
    }

    private static void saveStrategyResults(Map<String, List<StrategyResult>> tradeResultMap) {
        var rows = new ArrayList<ResultCsvRow>();
        for (var entry : tradeResultMap.entrySet()) {
            var groupName = entry.getKey();
            var strategyResultList = entry.getValue();
            for (var strategyResult : strategyResultList) {
                for (var symbol : strategyResult.getStockGroup().getSymbols()) {
                    var trades = strategyResult.getTrades(symbol);
                    Multimap<String, Trade> yearTrades = partitionByYear(trades);
                    var row = new ResultCsvRow(groupName, symbol, strategyResult.getStrategyPair());
                    for (int year = START_YEAR; year <= END_YEAR; year++) {
                        row.putStats(year, new TradeStatistics(yearTrades.get(String.valueOf(year))));
                    }
                    rows.add(row);
                }
            }
        }
        var resultCsv = new ResultCsv(START_YEAR, END_YEAR, rows);
        resultCsv.writeToFile();
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

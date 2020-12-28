package zhy2002.trading;

import zhy2002.trading.strategy.BuyBelowSMA;
import zhy2002.trading.strategy.SellAboveSMA;
import zhy2002.trading.strategy.StrategyPair;

import java.util.ArrayList;
import java.util.List;

public class TradeSimulator {

    private static final double START_FUND = 10_000;
    private static final String START_DATE = "2016-01-04";


    public void simulate1() {
        var result = simulateTrades(
                List.of("CBA.AX"),
                List.of(
                        new StrategyPair(new BuyBelowSMA(100), new SellAboveSMA(100))
                ));
        printResult(result);
    }

    private List<List<Trader>> simulateTrades(List<String> symbols, List<StrategyPair> strategyPairs) {
        var result = new ArrayList<List<Trader>>();
        for (String symbol : symbols) {
            Chart chart = new Chart(symbol);
            int startDayIndex = chart.findDateIndex(START_DATE);
            var traders = new ArrayList<Trader>();
            for (var pair : strategyPairs) {
                var trader = new Trader(chart, pair);
                trader.trade(START_FUND, startDayIndex);
                traders.add(trader);
            }
            result.add(traders);
        }
        return result;
    }

    private void printResult(List<List<Trader>> result) {
        for (var list : result) {
            for (var t : list) {
                System.out.println(t);
            }
        }
    }
}

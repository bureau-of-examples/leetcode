package zhy2002.trading;

import zhy2002.trading.strategy.BuyBelowRSI;
import zhy2002.trading.strategy.BuyBelowSMAWithMovement;
import zhy2002.trading.strategy.BuyBelowSMAWithTrend;
import zhy2002.trading.strategy.BuyBollingerBand;
import zhy2002.trading.strategy.SellAboveRSI;
import zhy2002.trading.strategy.SellAboveSMAWithMovement;
import zhy2002.trading.strategy.SellBollingerBand;
import zhy2002.trading.strategy.StrategyPair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TradeSimulator {

    private static final double START_FUND = 10_000;
    //csv data start date: 2015 May 01
    private static final String START_DATE = "2016-01-01";


    public void simulateBHP() {
        var symbols = List.of("BHP.AX");
        var strategies = List.of(
                new StrategyPair(new BuyBollingerBand(-0.9), new SellBollingerBand(0.2))
                //new StrategyPair(new BuyBelowSMAWithTrend(100), new SellAboveSMAWithTrend(100))
                //new StrategyPair(new BuyBelowSMAWithMovement(100), new SellAboveSMAWithMovement(100))
        );
        var result = simulateTrades(symbols, strategies);
        printResult(symbols, result);
    }

    public void simulate1() {
        var symbols = List.of("BHP.AX", "CBA.AX", "CSL.AX");
        var strategies = List.of(
                new StrategyPair(new BuyBelowRSI(), new SellAboveRSI())
                //new StrategyPair(new BuyBollingerBand(), new SellBollingerBand()),
                //new StrategyPair(new BuyBelowSMAWithMovement(100), new SellAboveSMAWithMovement(100))
                //new StrategyPair(new BuyBelowSMAWithEngulfing(100), new SellAboveSMAWithEngulfing(100))
        );
        var result = simulateTrades(symbols, strategies);
        printResult(symbols, result);
    }

    public void simulateMultiple() {
        var map = new LinkedHashMap<Chart, StrategyPair>();
        map.put(new Chart("BHP.AX"), new StrategyPair(new BuyBelowSMAWithMovement(100), new SellAboveSMAWithMovement(100)));
        map.put(new Chart("CBA.AX"), new StrategyPair(new BuyBelowSMAWithMovement(100), new SellAboveSMAWithMovement(100)));
        map.put(new Chart("CSL.AX"), new StrategyPair(new BuyBollingerBand(0), new SellBollingerBand(0)));

        var trader = new Trader(map);
        int startDayIndex = new Chart("CBA.AX").findDateIndex(START_DATE);
        trader.trade(START_FUND, startDayIndex);
        System.out.println(trader);
    }

    private Map<String, List<Trader>> simulateTrades(List<String> symbols, List<StrategyPair> strategyPairs) {
        var result = new HashMap<String, List<Trader>>();
        for (String symbol : symbols) {
            Chart chart = new Chart(symbol);
            int startDayIndex = chart.findDateIndex(START_DATE);
            result.put(symbol, new ArrayList<>());
            for (var pair : strategyPairs) {
                var trader = new Trader(chart, pair);
                trader.trade(START_FUND, startDayIndex);
                result.get(symbol).add(trader);
            }
        }
        return result;
    }

    private void printResult(List<String> symbols, Map<String, List<Trader>> result) {
        for (var symbol : symbols) {
            for (var trader : result.get(symbol)) {
                System.out.println(String.format("Symbol: %s, Buy Strategy: %s, Sell Strategy: %s, %s",
                        symbol, trader.getBuyStrategy(symbol), trader.getSellStrategy(symbol), trader));
                for (var trade : trader.getPastTrades()) {
                    System.out.println("===>" + trade);
                }
            }
        }
    }
}

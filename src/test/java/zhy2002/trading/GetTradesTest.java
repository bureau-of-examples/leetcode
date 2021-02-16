package zhy2002.trading;

import org.junit.Test;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.DaysBlowSMA;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.SMATurn;
import zhy2002.trading.condition.SMATurnSell;
import zhy2002.trading.condition.TrailingStopLoss;
import zhy2002.trading.strategy.Strategy;
import zhy2002.trading.strategy.StrategyPair;
import zhy2002.trading.trading.TradeStatistics;
import zhy2002.trading.trading.Trader;

import java.util.List;


public class GetTradesTest {

    private static final String START_DATE = "2018-01-01";

    private static final double START_FUND = 10_000;

    @Test
    public void dumpTrades() {
        var t1 = tradeSMATurn("REA.AX", 14, 13, 6, -0.005, 0.003, 30, 50, 0.85, 0.96);
        var t2 = tradeSMATurn("RIO.AX", 14, 13, 3, -0.005, 0.005, 20, 30, 0.75, 0.97);
        var t3 = tradeSMATurn("RMD.AX", 14, 12, 6, -0.006, 0.003, 50, 20, 0.75, 0.96);
        var t4 = tradeSMATurn("ALL.AX", 20, 12, 4, -0.004, 0.004, 50, 20, 0.8, 0.96);
        var traders = List.of(t1, t2, t3, t4);
        SimpleTradeSelector selector = new SimpleTradeSelector(traders, 10);
        System.out.println("Selected trades: ");
        var selected = selector.selectTrades();
        for (Trade t : selected) {
            System.out.println(t);
        }
        System.out.println(new TradeStatistics(selected));
    }

    private Trader tradeSMATurn(String symbol, int smaPeriods, int downWindow, int upWindow, double downRate, double upRate,
                                int trendPeriods, int trendWindow, double threshold, double percent) {
        var chart = new Chart(symbol);
        var strategyPair = new StrategyPair(
                new Strategy("SMATurn", new And(
                        new SMATurn(
                                smaPeriods,
                                downWindow,
                                upWindow,
                                downRate,
                                upRate
                        ),
                        new DaysBlowSMA(
                                trendPeriods,
                                trendWindow,
                                threshold
                        )
                )),
                new Strategy("TrailingStopLoss", new Or(
                        new SMATurnSell(),
                        new TrailingStopLoss(percent, Integer.MAX_VALUE)
                ))
        );

        var trader = new Trader(chart, strategyPair);
        trader.trade(START_FUND, chart.findDateIndex(START_DATE));
        System.out.println("Trades for " + chart.getSymbol());
        for (var t : trader.getTrades()) {
            System.out.println(t);
        }
        return trader;
    }
}

package zhy2002.trading;

import org.junit.Test;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.DaysBlowSMA;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.SMATurn;
import zhy2002.trading.condition.SMATurnSell;
import zhy2002.trading.condition.TrailingStopLoss;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;
import zhy2002.trading.trading.Trader;


public class GetTradesTest {

    private static final String START_DATE = "2020-01-01";

    private static final double START_FUND = 10_000;

    @Test
    public void dumpTrades() {
        tradeSMATurn("REA.AX");
        tradeSMATurn("RIO.AX");
    }


    private void tradeSMATurn(String symbol) {
        var buys = new StrategyGeneratorV2(
                "SMATurn-" + symbol,
                new ParameterCrossProduct()
                        .withParameter("smaPeriods", new int[]{14})
                        .withParameter("downWindow", new int[]{13})
                        .withParameter("upWindow", new int[]{3})
                        .withParameter("downRate", new double[]{-0.005})
                        .withParameter("upRate", new double[]{0.005})
                        .withParameter("trendPeriods", new int[]{30})
                        .withParameter("trendWindow", new int[]{30})
                        .withParameter("threshold", new double[]{0.75}),
                ps -> new And(
                        new SMATurn(
                                ps.getInt("smaPeriods"),
                                ps.getInt("downWindow"),
                                ps.getInt("upWindow"),
                                ps.getDouble("downRate"),
                                ps.getDouble("upRate")
                        ),
                        new DaysBlowSMA(
                                ps.getInt("trendPeriods"),
                                ps.getInt("trendWindow"),
                                ps.getDouble("threshold")
                        )
                ));
        var sells = new StrategyGeneratorV2(
                "TrailingStopLoss",
                new ParameterCrossProduct()
                        .withParameter("percent", new double[]{0.96}),
                ps -> new Or(
                        new SMATurnSell(),
                        new TrailingStopLoss(ps.getDouble("percent"), Integer.MAX_VALUE)
                ));

        var chart = new Chart(symbol);
        for (var b : buys) {
            for (var s : sells) {
                var pair = new StrategyPair(b, s);
                var trader = new Trader(chart, pair);
                trader.trade(START_FUND, chart.findDateIndex(START_DATE));
                System.out.println("Trades for " + chart.getSymbol());
                for (var t : trader.getTrades()) {
                    System.out.println(t);
                }
            }
        }
    }
}

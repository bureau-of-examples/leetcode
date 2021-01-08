package zhy2002.trading.test;

import zhy2002.trading.adaptor.SMAArrayExtractor;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CloseRange;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearSMA;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.RegressionTrend;
import zhy2002.trading.condition.StopLoss;
import zhy2002.trading.condition.TakeProfit;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;

import java.util.List;

/**
 * Enters when long term trend is up and short term trend is bouncing off long term trend.
 * Exits when stop loss and profit taking.
 */
public class SMABounceSetup extends BackTestSetup {

    @Override
    public List<StrategyPair> createStrategyPairs() {
        var buys = new StrategyGeneratorV2(
                "SMABounce",
                new ParameterCrossProduct()
                        .withParameter("slowPeriods", new int[]{50, 100})
                        .withParameter("slowWindow", new int[]{7, 10, 13})
                        .withParameter("fastPeriods", new int[]{5, 7,})
                        .withParameter("fastWindow", new int[]{3, 5, 7})
                        .withParameter("minFactor", new double[]{0.99, 1})
                        .withParameter("gap", new double[]{0.01, 0.02}),
                ps -> new And(
                        new CloseRange(1, 2),
                        new NearSMA(
                                ps.getInt("slowPeriods"),
                                ps.getDouble("minFactor"),
                                ps.getDouble("minFactor") + ps.getDouble("gap")),
                        new RegressionTrend(new SMAArrayExtractor(
                                ps.getInt("fastPeriods"),
                                ps.getInt("fastWindow")),
                                Comparison.HIGHER,
                                0),
                        new RegressionTrend(new SMAArrayExtractor(
                                ps.getInt("slowPeriods"),
                                ps.getInt("slowWindow")),
                                Comparison.HIGHER,
                                0)
                ));
        var sells = new StrategyGeneratorV2(
                "TakeProfit",
                new ParameterCrossProduct()
                        .withParameter("factor", new double[]{0.96, 0.97})
                        .withParameter("winRate", new double[]{1.5, 2, 2.5, 3}),
                ps -> new Or(
                        new StopLoss(ps.getDouble("factor")),
                        new TakeProfit((1 - ps.getDouble("factor")) * ps.getDouble("winRate"))
                ));
        return allStrategyPairs(buys, sells);
    }

}

package zhy2002.trading.test;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.BuyCrossSMA;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.TrailingStopLoss;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;

import java.util.List;

// a trend following strategy
public class CrossSMASetup extends BackTestSetup {

    @Override
    public List<StrategyPair> createStrategyPairs() {
        var buys = new StrategyGeneratorV2(
                "BuyCrossSMA",
                new ParameterCrossProduct()
                        .withParameter("smaPeriods", new int[]{5, 7, 9})
                        .withParameter("proceedingLowers", new int[]{2, 3, 4}),
                ps -> new And(
                        new BuyCrossSMA(ps.getInt("smaPeriods"), ps.getInt("proceedingLowers"))
                ));
        var sells = new StrategyGeneratorV2(
                "TrailingStopLoss",
                new ParameterCrossProduct()
                        .withParameter("percent", new double[]{0.95, 0.96, 0.97}),
                ps -> new Or(
                        new TrailingStopLoss(ps.getDouble("percent"), Integer.MAX_VALUE)
                ));
        return allStrategyPairs(buys, sells);
    }
}

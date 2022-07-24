package zhy2002.trading.test;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.EMAChangeLowerBound;
import zhy2002.trading.condition.HoldAfterDays;
import zhy2002.trading.condition.NearBollingerLower;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.TrailingStopLoss;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;

import java.util.List;

public class BollingerBandSetup extends BackTestSetup {

    @Override
    public List<StrategyPair> createStrategyPairs() {
        var buyGenerator = new StrategyGeneratorV2(
                "NearBollingerLower",
                new ParameterCrossProduct()
                        .withParameter("atrRatio", new double[]{1, 0.7, 0.3})
                        .withParameter("boundRatio", new double[]{-0.06, -0.05, -0.04}),
                ps -> new And(
                        new NearBollingerLower(ps.getDouble("atrRatio")),
                        new EMAChangeLowerBound(7, 5, ps.getDouble("boundRatio"))
                )
        );
        var sellGenerator = new StrategyGeneratorV2(
                "TrailingStopLoss",
                new ParameterCrossProduct()
                        .withParameter("ratio", new double[]{0.96, 0.97})
                        .withParameter("holdDays", new int[]{20, 25}),
                ps -> new Or(
                        new TrailingStopLoss(ps.getDouble("ratio"), Integer.MAX_VALUE),
                        new HoldAfterDays(ps.getInt("holdDays"))
                )
        );

        return allStrategyPairs(buyGenerator, sellGenerator);
    }
}

package zhy2002.trading.test;

import zhy2002.trading.StockGroup;
import zhy2002.trading.adaptor.SMAArrayExtractor;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.BelowBollingerBand;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.HoldAfterDays;
import zhy2002.trading.condition.NearBollingerLower;
import zhy2002.trading.condition.NearBollingerUpper;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.RegressionTrend;
import zhy2002.trading.condition.StopLoss;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;

import java.util.List;

public class BollingerBandSetup extends BackTestSetup {

    @Override
    public List<StockGroup> createStockGroups() {
        return List.of(
                new StockGroup("AU-FIN", List.of("RIO.AX"))
        );
    }

    @Override
    public List<StrategyPair> createStrategyPairs() {
        var buyGenerator = new StrategyGeneratorV2(
                "BuyBollingerBand",
                new ParameterCrossProduct()
                        .withParameter("atrRatio", new double[]{-1, -0.9, -0.8, -0.6})
                        .withParameter("trendDegree", new int[]{-10, -8, -6}),
                ps -> new And(
                        new NearBollingerLower(ps.getDouble("atrRatio")),
                        new RegressionTrend(
                                new SMAArrayExtractor(20, 6),
                                Comparison.HIGHER,
                                Math.tan(Math.toRadians(ps.getInt("trendDegree"))))
                )
        );
        var sellGenerator = new StrategyGeneratorV2(
                "SellBollingerBand",
                new ParameterCrossProduct()
                        .withParameter("atrRatio", new double[]{0.1, 0.2, 0.3, 0.4})
                        .withParameter("belowDays", new int[]{2, 3, 4}),
                ps -> new Or(
                        new NearBollingerUpper(ps.getDouble("atrRatio")),
                        new BelowBollingerBand(ps.getInt("belowDays")),
                        new HoldAfterDays(25),
                        new StopLoss(0.1)
                )
        );

        return allStrategyPairs(buyGenerator, sellGenerator);
    }
}

package zhy2002.trading.test;

import zhy2002.trading.StockGroup;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearBollingerLower;
import zhy2002.trading.condition.TrailingStopLoss;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;

import java.util.List;

public class BelowSMASetup extends BackTestSetup {
    @Override
    public List<StockGroup> createStockGroups() {
        return List.of(
                new StockGroup("AU-FIN", List.of("CBA.AX"))
        );
    }

    @Override
    public List<StrategyPair> createStrategyPairs() {
        // position then reversal
        var buys = new StrategyGeneratorV2(
                "BelowSMA",
                new ParameterCrossProduct()
                        .withParameter("smaPeriods", new int[]{50, 100})
                        .withParameter("atrRatio", new double[]{-1, -0.9, -0.8, -0.6}),
                ps -> new And(
                        new CompareWithSMA(Comparison.LOWER, ps.getInt("smaPeriods")),
                        new NearBollingerLower(ps.getDouble("atrRatio"))
                ));
        var sells = new StrategyGeneratorV2(
                "AboveSMA",
                new ParameterCrossProduct()
                        .withParameter("smaPeriods", new int[]{200})
                        .withParameter("stopLossPercent", new double[]{0.85, 0.9, 0.95}),
                ps -> new And(
                        new CompareWithSMA(Comparison.HIGHER, ps.getInt("smaPeriods")),
                        new TrailingStopLoss(ps.getDouble("stopLossPercent"), Integer.MAX_VALUE)
                ));

        return allStrategyPairs(buys, sells);
    }
}

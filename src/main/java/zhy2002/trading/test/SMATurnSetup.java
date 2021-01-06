package zhy2002.trading.test;

import zhy2002.trading.condition.SMATurn;
import zhy2002.trading.StockGroup;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.TrailingStopLoss;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;

import java.util.List;

public class SMATurnSetup extends BackTestSetup {
    @Override
    public List<StockGroup> createStockGroups() {
        return List.of(
                new StockGroup("AU-FIN", List.of("NAB.AX"))
        );
    }

    @Override
    public List<StrategyPair> createStrategyPairs() {
        var buys = new StrategyGeneratorV2(
                "SMATurn",
                new ParameterCrossProduct(),
                ps -> new SMATurn());
        var sells = new StrategyGeneratorV2(
                "TrailingStopLoss",
                new ParameterCrossProduct()
                        .withParameter("percent", new double[]{0.95,0.96,0.97,0.98}),
                ps -> new Or(
                        new TrailingStopLoss(ps.getDouble("percent"), Integer.MAX_VALUE)
                ));
        return allStrategyPairs(buys, sells);
    }
}

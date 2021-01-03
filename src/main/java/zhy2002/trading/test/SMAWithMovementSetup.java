package zhy2002.trading.test;

import zhy2002.trading.StockGroup;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.ConsecutiveMovement;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;

import java.util.List;

public class SMAWithMovementSetup extends BackTestSetup {
    @Override
    public List<StockGroup> createStockGroups() {
        return List.of(
                new StockGroup("AU-FIN", List.of("CBA.AX")),
                new StockGroup("AU-MAT", List.of("BHP.AX"))
        );
    }

    @Override
    public List<StrategyPair> createStrategyPairs() {
        // position then reversal
        var buySMAWithMovement = new StrategyGeneratorV2(
                "BelowSMA+Movement",
                new ParameterCrossProduct()
                        .withParameter("smaPeriods", new int[]{20, 50, 100, 200})
                        .withParameter("times", new int[]{2, 3, 4}),
                ps -> new And(
                        new CompareWithSMA(Comparison.LOWER, ps.getInt("smaPeriods")),
                        new ConsecutiveMovement(Comparison.HIGHER, ps.getInt("times"))
                ));
        var sellSMAWithMovement = new StrategyGeneratorV2(
                "AboveSMA+Movement",
                new ParameterCrossProduct()
                        .withParameter("smaPeriods", new int[]{20, 50, 100, 200})
                        .withParameter("times", new int[]{2, 3, 4}),
                ps -> new And(
                        new CompareWithSMA(Comparison.HIGHER, ps.getInt("smaPeriods")),
                        new ConsecutiveMovement(Comparison.LOWER, ps.getInt("times"))
                ));

        return allStrategyPairs(buySMAWithMovement, sellSMAWithMovement);
    }
}

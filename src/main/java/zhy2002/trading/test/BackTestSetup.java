package zhy2002.trading.test;

import zhy2002.trading.StockGroup;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;

import java.util.ArrayList;
import java.util.List;

/**
 * Test all stock groups against all strategy pairs.
 */
public abstract class BackTestSetup {

    // default
    public List<StockGroup> createStockGroups() {
        return List.of(
                new StockGroup("AU", List.of("NAB.AX", "CBA.AX", "BHP.AX", "RIO.AX"))
        );
    }

    public abstract List<StrategyPair> createStrategyPairs();

    protected List<StrategyPair> allStrategyPairs(StrategyGeneratorV2 buys, StrategyGeneratorV2 sells) {
        List<StrategyPair> result = new ArrayList<>();
        for (var b : buys) {
            for (var s : sells) {
                result.add(new StrategyPair(b, s));
            }
            sells.reset();
        }
        return result;
    }
}

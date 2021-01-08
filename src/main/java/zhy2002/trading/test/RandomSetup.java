package zhy2002.trading.test;

import zhy2002.trading.condition.RandomBuy;
import zhy2002.trading.condition.RandomSell;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;

import java.util.List;
import java.util.Random;

/**
 * Used as a benchmark for other strategies.
 */
public class RandomSetup extends BackTestSetup {

    @Override
    public List<StrategyPair> createStrategyPairs() {
        var rand = new Random();
        var buys = new StrategyGeneratorV2(
                "RandomBuy",
                new ParameterCrossProduct()
                        .withParameter("buyProbability", new double[]{0.05})
                        .withParameter("dummy1", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                        .withParameter("dummy2", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
                        .withParameter("dummy3", new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),
                ps -> new RandomBuy(rand, ps.getDouble("buyProbability")));
        var sells = new StrategyGeneratorV2(
                "RandomSell",
                new ParameterCrossProduct()
                        .withParameter("minHoldDays", new int[]{7})
                        .withParameter("maxHoldDays", new int[]{30}),
                ps -> new RandomSell(rand, ps.getInt("minHoldDays"), ps.getInt("maxHoldDays")));
        return allStrategyPairs(buys, sells);
    }
}

package zhy2002.trading.test;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CloseAboveSMARate;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.EMAChangeLowerBound;
import zhy2002.trading.condition.Not;
import zhy2002.trading.condition.SMAChangeLowerBound;
import zhy2002.trading.condition.TrailingStopLoss;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;

import java.util.List;

// a trend following strategy
public class CloseAboveSMARateSetup extends BackTestSetup {

    @Override
    public List<StrategyPair> createStrategyPairs() {
        var buys = new StrategyGeneratorV2(
                "CloseAboveSMARate",
                new ParameterCrossProduct()
                        .withParameter("smaPeriods", new int[]{50, 100})
                        .withParameter("windowRate", new double[]{0.4, 0.5})
                        .withParameter("minRate", new double[]{0.95, 0.9})
                        .withParameter("avgDayGain", new double[]{0.001, 0.002, 0.003}),
                ps -> {
                    var window = (int) (ps.getInt("smaPeriods") * ps.getDouble("windowRate"));
                    return new And(
                            new CloseAboveSMARate(
                                    ps.getInt("smaPeriods"),
                                    window,
                                    ps.getDouble("minRate")),
                            new SMAChangeLowerBound(
                                    ps.getInt("smaPeriods"),
                                    window,
                                    (window - 1) * ps.getDouble("avgDayGain")),
                            new CompareWithSMA(Comparison.LOWER, ps.getInt("smaPeriods"))
                    );
                });
        var sells = new StrategyGeneratorV2(
                "TrailingStopLoss",
                new ParameterCrossProduct()
                        .withParameter("percent", new double[]{0.97, 0.9}),
                ps -> new And(
                        new Not(new EMAChangeLowerBound(20, 2, 0)),
                        new TrailingStopLoss(ps.getDouble("percent"), Integer.MAX_VALUE)
                ));
        return allStrategyPairs(buys, sells);
    }
}

package zhy2002.trading.strategy;

import org.junit.Test;
import zhy2002.trading.adaptor.SMAArrayExtractor;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearBollingerLower;
import zhy2002.trading.condition.RegressionTrend;

public class StrategyGeneratorV2Test {

    @Test
    public void test() {
        var buyGenerator = new StrategyGeneratorV2(
                "SMA with trend",
                new ParameterCrossProduct()
                        .withParameter("smaPeriods", new int[]{20, 50, 100})
                        .withParameter("k", new double[]{0d, -0.05}),
                ps -> new And(
                        new CompareWithSMA(Comparison.LOWER, ps.getInt("smaPeriods")),
                        new RegressionTrend(new SMAArrayExtractor(), Comparison.HIGHER, ps.getDouble("k")),
                        new NearBollingerLower()
                ));

        for (var g : buyGenerator) {
            System.out.println(g);
        }
    }

}
package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearBollingerLower;
import zhy2002.trading.condition.RegressionTrend;
import zhy2002.trading.adaptor.SMAArrayExtractor;

public class BuyBelowSMAWithTrend extends Strategy {

    private final int smaPeriods;

    public BuyBelowSMAWithTrend(int smaPeriods) {
        super(new And(
                new CompareWithSMA(Comparison.LOWER, smaPeriods),
                new RegressionTrend(new SMAArrayExtractor(), Comparison.HIGHER, -0.05),
                new NearBollingerLower()
        ));
        this.smaPeriods = smaPeriods;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", getClass().getSimpleName(), smaPeriods);
    }
}

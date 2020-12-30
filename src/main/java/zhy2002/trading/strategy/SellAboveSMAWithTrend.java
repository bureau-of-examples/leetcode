package zhy2002.trading.strategy;

import zhy2002.trading.adaptor.SMAArrayExtractor;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearBollingerUpper;
import zhy2002.trading.condition.RegressionTrend;

public class SellAboveSMAWithTrend extends Strategy {

    private final int smaPeriods;

    public SellAboveSMAWithTrend(int smaPeriods) {
        super(new And(
                new CompareWithSMA(Comparison.HIGHER, smaPeriods),
                new RegressionTrend(new SMAArrayExtractor(), Comparison.LOWER, 0.05),
                new NearBollingerUpper()
        ));
        this.smaPeriods = smaPeriods;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", getClass().getSimpleName(), smaPeriods);
    }
}

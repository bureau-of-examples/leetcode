package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearBollingerUpper;
import zhy2002.trading.condition.SMATrend;

public class SellAboveSMAWithTrend extends Strategy {

    private final int smaPeriods;

    public SellAboveSMAWithTrend(int smaPeriods) {
        super(new And(
                new CompareWithSMA(Comparison.HIGHER, smaPeriods),
                new SMATrend(Comparison.LOWER, 0.05,50, 9),
                new NearBollingerUpper()
        ));
        this.smaPeriods = smaPeriods;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", getClass().getSimpleName(), smaPeriods);
    }
}

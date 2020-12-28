package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.BearishEngulfing;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;

public class SellAboveSMAWithEngulfing extends Strategy {

    private final int smaPeriods;

    public SellAboveSMAWithEngulfing(int smaPeriods) {
        super(new And(
                new CompareWithSMA(Comparison.HIGHER, smaPeriods),
                new BearishEngulfing()
        ));
        this.smaPeriods = smaPeriods;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", getClass().getSimpleName(), smaPeriods);
    }
}

package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.BullishEngulfing;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;


public class BuyBelowSMAWithEngulfing extends Strategy {

    private final int smaPeriods;

    public BuyBelowSMAWithEngulfing(int smaPeriods) {
        super(new And(
                new CompareWithSMA(Comparison.LOWER, smaPeriods),
                new BullishEngulfing()
        ));
        this.smaPeriods = smaPeriods;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", getClass().getSimpleName(), smaPeriods);
    }
}

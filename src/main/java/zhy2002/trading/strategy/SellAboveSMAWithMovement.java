package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.ConsecutiveMovement;

public class SellAboveSMAWithMovement extends Strategy {

    private final int smaPeriods;

    public SellAboveSMAWithMovement(int smaPeriods) {
        super(new And(
                new CompareWithSMA(Comparison.HIGHER, smaPeriods),
                new ConsecutiveMovement(Comparison.LOWER, 2)
        ));
        this.smaPeriods = smaPeriods;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", getClass().getSimpleName(), smaPeriods);
    }
}

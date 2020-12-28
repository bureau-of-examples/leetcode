package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.ConsecutiveMovement;

public class BuyBelowSMA extends Strategy {

    public BuyBelowSMA(int smaPeriods) {
        super(new And(
                new CompareWithSMA(Comparison.LOWER, smaPeriods),
                new ConsecutiveMovement(Comparison.HIGHER, 2)
        ));
    }
}

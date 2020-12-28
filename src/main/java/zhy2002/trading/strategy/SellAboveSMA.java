package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.ConsecutiveMovement;

public class SellAboveSMA extends Strategy {

    public SellAboveSMA(int smaPeriods) {
        super(new And(
                new CompareWithSMA(Comparison.HIGHER, smaPeriods),
                new ConsecutiveMovement(Comparison.LOWER, 2)
        ));
    }
}

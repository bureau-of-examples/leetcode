package zhy2002.trading.strategy;

import zhy2002.trading.condition.CompareWiThRSI;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.HoldAfterDays;
import zhy2002.trading.condition.Or;

public class SellAboveRSI extends Strategy {
    public SellAboveRSI() {
        super(new Or(
                new CompareWiThRSI(Comparison.HIGHER, 40),
                new HoldAfterDays(10)
        ));
    }
}

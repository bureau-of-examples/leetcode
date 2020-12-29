package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.CompareWiThRSI;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.pricing.OpenPrice;

public class BuyBelowRSI extends Strategy {
    public BuyBelowRSI() {
        super(new And(
                new CompareWithSMA(Comparison.HIGHER, 200),
                new CompareWiThRSI(Comparison.LOWER, 30)
        ), new OpenPrice());
    }
}

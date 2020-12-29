package zhy2002.trading.strategy;

import zhy2002.trading.condition.BollingerBandTrend;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearBollingerUpper;
import zhy2002.trading.condition.Not;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.StopLoss;


public class SellBollingerBand extends Strategy {
    public SellBollingerBand() {
        super(new Or(
                new NearBollingerUpper(),
                new StopLoss(0.8),
                new Not(new BollingerBandTrend(Comparison.HIGHER))
        ));

    }
}

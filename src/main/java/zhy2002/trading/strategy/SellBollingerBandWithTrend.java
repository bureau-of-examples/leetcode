package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.BollingerBandTrend;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearBollingerUpper;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.StopLoss;


public class SellBollingerBandWithTrend extends Strategy {
    public SellBollingerBandWithTrend() {
        super(new Or(
                new And(
                        new NearBollingerUpper(),
                        new BollingerBandTrend(Comparison.HIGHER)
                ),
                new StopLoss(0.8)
        ));

    }
}

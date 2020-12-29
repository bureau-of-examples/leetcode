package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.NearBollingerLower;

public class BuyBollingerBandWithTrend extends Strategy {

    public BuyBollingerBandWithTrend() {
        super(new And(
                new NearBollingerLower()//,
                //new Not(new BollingerBandTrend(Comparison.HIGHER))

        ));
    }
}

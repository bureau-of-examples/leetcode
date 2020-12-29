package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.BollingerBandTrend;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearBollingerLower;
import zhy2002.trading.condition.Not;

public class BuyBollingerBand extends Strategy {

    public BuyBollingerBand() {
        super(new And(
                new NearBollingerLower()//,
                //new Not(new BollingerBandTrend(Comparison.HIGHER))

        ));
    }
}

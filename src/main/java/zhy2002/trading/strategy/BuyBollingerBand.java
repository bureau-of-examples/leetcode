package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.BollingerBandTrend;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearBollingerLower;

public class BuyBollingerBand extends Strategy {

    public BuyBollingerBand() {
        super(new And(
                new NearBollingerLower(),
                new BollingerBandTrend(Comparison.HIGHER)
        ));
    }
}

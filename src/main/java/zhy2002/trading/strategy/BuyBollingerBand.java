package zhy2002.trading.strategy;

import zhy2002.trading.adaptor.SMAArrayExtractor;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearBollingerLower;
import zhy2002.trading.condition.RegressionTrend;


public class BuyBollingerBand extends Strategy {

    public BuyBollingerBand(double atrRatio) {
        super(new And(
                new NearBollingerLower(atrRatio),
                new RegressionTrend(new SMAArrayExtractor(20, 6), Comparison.HIGHER, Math.tan(Math.toRadians(-10)))
        ));
    }
}

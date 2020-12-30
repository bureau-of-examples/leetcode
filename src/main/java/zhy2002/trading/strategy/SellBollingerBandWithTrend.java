package zhy2002.trading.strategy;

import zhy2002.trading.adaptor.SMAArrayExtractor;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.NearBollingerUpper;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.RegressionTrend;
import zhy2002.trading.condition.StopLoss;


public class SellBollingerBandWithTrend extends Strategy {
    public SellBollingerBandWithTrend() {
        super(new Or(
                new And(
                        new NearBollingerUpper(),
                        new RegressionTrend(new SMAArrayExtractor(20, 9), Comparison.HIGHER, -0.05)
                ),
                new StopLoss(0.8)
        ));

    }
}

package zhy2002.trading.strategy;

import zhy2002.trading.condition.And;
import zhy2002.trading.condition.BelowBollingerBand;
import zhy2002.trading.condition.HoldAfterDays;
import zhy2002.trading.condition.NearBollingerUpper;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.ShiftLeft;
import zhy2002.trading.condition.StopLoss;


public class SellBollingerBand extends Strategy {
    public SellBollingerBand(double atrRatio) {
        super(new Or(
                new And(
                        new NearBollingerUpper(atrRatio)
                ),
                new ShiftLeft(new BelowBollingerBand(3)),
                new HoldAfterDays(25),
                new StopLoss(0.92)
        ));
    }
}

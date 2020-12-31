package zhy2002.trading.strategy;

import zhy2002.trading.adaptor.SMAArrayExtractor;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.BelowBollingerBand;
import zhy2002.trading.condition.CompareWithSMA;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.ConsecutiveMovement;
import zhy2002.trading.condition.HoldAfterDays;
import zhy2002.trading.condition.NearBollingerLower;
import zhy2002.trading.condition.NearBollingerUpper;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.RegressionTrend;
import zhy2002.trading.condition.StopLoss;
import zhy2002.trading.condition.TradeCondition;

import java.util.ArrayList;
import java.util.List;

public final class StrategyGenerator {

    public List<Strategy> buyBollingerBand(double[] a, int[] d) {
        var result = new ArrayList<Strategy>();
        for (double atrRatio : a) {
            for (int trendDegree : d) {
                result.add(new Strategy(
                        String.format("BuyBollingerBand(%.2f, %d)", atrRatio, trendDegree),
                        new And(
                                new NearBollingerLower(atrRatio),
                                new RegressionTrend(new SMAArrayExtractor(20, 6), Comparison.HIGHER, Math.tan(Math.toRadians(trendDegree))))
                ));
            }
        }
        return result;
    }

    public List<Strategy> sellBollingerBand(double[] a, int[] b) {
        var result = new ArrayList<Strategy>();
        for (double atrRatio : a) {
            for (int belowDays : b) {
                result.add(new Strategy(
                        String.format("SellBollingerBand(%.2f, %d)", atrRatio, belowDays),
                        new Or(
                                new NearBollingerUpper(atrRatio),
                                new BelowBollingerBand(belowDays),
                                new HoldAfterDays(25),
                                new StopLoss(0.1)
                        )
                ));
            }
        }
        return result;
    }

    public List<Strategy> sellAboveSMAWithMovement(int[] msaPeriodsList, int[] timesList) {
        var result = new ArrayList<Strategy>();
        for (var smaPeriods : msaPeriodsList) {
            for (int times : timesList) {
                result.add(new Strategy(
                        String.format("SellAboveSMAWithMovement(%d, %d)", smaPeriods, times),
                        new And(
                                new CompareWithSMA(Comparison.HIGHER, smaPeriods),
                                new ConsecutiveMovement(Comparison.LOWER, times)
                        )
                ));
            }
        }
        return result;
    }

    public List<Strategy> buyBelowSMAWithMovement(int[] msaPeriodsList, int[] timesList) {
        var result = new ArrayList<Strategy>();
        for (var smaPeriods : msaPeriodsList) {
            for (int times : timesList) {
                result.add(new Strategy(
                        String.format("BuyBelowSMAWithMovement(%d, %d)", smaPeriods, times),
                        new And(
                                new CompareWithSMA(Comparison.LOWER, smaPeriods),
                                new ConsecutiveMovement(Comparison.HIGHER, times)
                        )
                ));
            }
        }
        return result;
    }
}

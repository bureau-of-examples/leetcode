package zhy2002.trading.test;

import zhy2002.trading.StockGroup;
import zhy2002.trading.condition.AboveBollingerBand;
import zhy2002.trading.condition.And;
import zhy2002.trading.condition.BelowBollingerBand;
import zhy2002.trading.condition.CandleCross;
import zhy2002.trading.condition.CandleCross2;
import zhy2002.trading.condition.Comparison;
import zhy2002.trading.condition.ConsecutiveMovement;
import zhy2002.trading.condition.HoldAfterDays;
import zhy2002.trading.condition.Or;
import zhy2002.trading.condition.SMATrend;
import zhy2002.trading.condition.StopLoss;
import zhy2002.trading.condition.TakeProfit;
import zhy2002.trading.condition.TrailingStopLoss;
import zhy2002.trading.strategy.ParameterCrossProduct;
import zhy2002.trading.strategy.StrategyGeneratorV2;
import zhy2002.trading.strategy.StrategyPair;

import java.util.List;

public class SMATurnSetup extends BackTestSetup {
    @Override
    public List<StockGroup> createStockGroups() {
        return List.of(
                new StockGroup("AU-FIN", List.of("NAB.AX", "CBA.AX", "BHP.AX", "RIO.AX"))
        );
    }

    @Override
    public List<StrategyPair> createStrategyPairs() {
        var buys = new StrategyGeneratorV2(
                "SMATurn2",
                new ParameterCrossProduct(),
                ps -> new And(
                        //new BelowBollingerBand(1)
                        //new SMATrend(20, Comparison.HIGHER, 10),
                        new CandleCross()
                        //  new SMALessThan(5, 20, 5, 0.005)

                ));
        var sells = new StrategyGeneratorV2(
                "TrailingStopLoss",
                new ParameterCrossProduct()
                        .withParameter("percent", new double[]{0.97})
                        .withParameter("profit", new double[]{0.075}),
                ps -> new Or(
                        //new CandleCross2(),
                        //new TrailingStopLoss(ps.getDouble("percent"), Integer.MAX_VALUE)
                        new StopLoss(0.97),
                        new TakeProfit(ps.getDouble("profit"))
                ));
        return allStrategyPairs(buys, sells);
    }
}

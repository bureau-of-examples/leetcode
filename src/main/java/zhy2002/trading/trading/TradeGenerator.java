package zhy2002.trading.trading;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;
import zhy2002.trading.Trade;
import zhy2002.trading.Trader;
import zhy2002.trading.strategy.StrategyPair;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class TradeGenerator {

    private final double initialFund;

    public TradeGenerator() {
        this(10_000d);
    }

    public List<Trade> generate(Chart chart, StrategyPair strategyPair, String startDate/* e.g. "2016-01-01"*/) {
        List<Trade> result = new ArrayList<>();
        var buyStrategy = strategyPair.getBuyStrategy();
        int startIndex = chart.findDateIndex(startDate);
        for (int i = startIndex; i < chart.getPeriods(); i++) {
            if (buyStrategy.shouldTakeAction(null, chart, i)) {
                double price = buyStrategy.decidePrice(chart, i);
                var candle = chart.getCandle(i);
                if (candle.isPriceInRange(price)) {
                    int share = (int) (initialFund / price);
                    result.add(new Trade(chart, i, price, share));
                }
            }
        }

        var sellStrategy = strategyPair.getSellStrategy();
        Trader dummyTrader = new Trader(chart, strategyPair);
        for (var trade : result) { // close the trades
            dummyTrader.setCurrentTrade(trade);
            for (int i = trade.getBuyDayIndex() + 1; i < chart.getPeriods(); i++) {
                if (sellStrategy.shouldTakeAction(dummyTrader, chart, i)) {
                    double price = sellStrategy.decidePrice(chart, i);
                    var candle = chart.getCandle(i);
                    if (candle.isPriceInRange(price)) {
                        trade.complete(i, price);
                        break; // done with this trade
                    }
                }
            }
        }
        return result;
    }

}

package zhy2002.trading;

import zhy2002.trading.strategy.Strategy;
import zhy2002.trading.strategy.StrategyPair;

import java.util.ArrayList;
import java.util.List;


public class Trader {

    private final List<Trade> pastTrades = new ArrayList<>();
    private final Chart chart;
    private final Strategy buyStrategy;
    private final Strategy sellStrategy;

    private double fund;
    private Trade currentTrade;

    public Trader(Chart chart, StrategyPair strategyPair) {
        this.chart = chart;
        this.buyStrategy = strategyPair.getBuyStrategy();
        this.sellStrategy = strategyPair.getSellStrategy();
    }

    public void trade(double startFund, int startDayIndex) {
        fund = startFund;
        currentTrade = null;

        for (int index = startDayIndex; index < chart.getPeriods(); index++) {
            if (currentTrade == null) { // check for buy
                if (buyStrategy.shouldTakeAction(chart, index)) {
                    double price = buyStrategy.decidePrice(chart, index);
                    int share = (int) (fund / price);
                    fund -= share * price;
                    currentTrade = new Trade(chart, index, price, share);
                }
            } else { // check for sell
                if (sellStrategy.shouldTakeAction(chart, index)) {
                    double price = sellStrategy.decidePrice(chart, index);
                    fund += price * currentTrade.getVolume();
                    currentTrade.complete(index, price);
                    pastTrades.add(currentTrade);
                    currentTrade = null;
                }
            }
        }
    }

    // as at before entering the current trade
    public double lastFund() {
        return fund + (currentTrade == null ? 0 : currentTrade.getBuyPrice() * currentTrade.getVolume());
    }

    @Override
    public String toString() {
        return String.format("Symbol: %s, Trade: %d, Fund: %.2f", chart.getSymbol(), pastTrades.size(), lastFund());
    }
}

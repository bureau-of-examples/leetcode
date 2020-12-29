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
                if (buyStrategy.shouldTakeAction(this, index)) {
                    double price = buyStrategy.decidePrice(chart, index);
                    int share = (int) (fund / price);
                    fund -= share * price;
                    currentTrade = new Trade(chart, index, price, share);
                }
            } else { // check for sell
                if (sellStrategy.shouldTakeAction(this, index)) {
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

    public List<Trade> getPastTrades() {
        return pastTrades;
    }

    public Trade getCurrentTrade() {
        return currentTrade;
    }

    public Chart getChart() {
        return chart;
    }

    @Override
    public String toString() {
        return String.format("Symbol: %s, Buy Strategy: %s, Sell Strategy: %s, Trade: %d, Fund: %.2f, Betting Average: %.2f, Win Loss Ratio: %.2f",
                chart.getSymbol(), buyStrategy, sellStrategy, pastTrades.size(), lastFund(), getBettingAverage(), getWinLossRatio());
    }

    private double getBettingAverage() {
        double winCount = 0;
        for (var t : pastTrades) {
            if (t.getBuyPrice() < t.getSellPrice()) {
                winCount++;
            }
        }
        return winCount / pastTrades.size();
    }

    private double getWinLossRatio() {
        double winPercent = 0;
        int winCount = 0;
        double lossPercent = 0;
        int lossCount = 0;
        for (var t : pastTrades) {
            var p = (t.getSellPrice() - t.getBuyPrice()) / t.getBuyPrice();
            if (p > 0) {
                winPercent += p;
                winCount++;
            } else {
                lossPercent += -p;
                lossCount++;
            }
        }
        if (winCount > 0) {
            winPercent /= winCount;
        }
        if (lossCount > 0) {
            lossPercent /= lossCount;
        }
        return winPercent / lossPercent;
    }

}

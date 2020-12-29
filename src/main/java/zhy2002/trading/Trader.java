package zhy2002.trading;

import zhy2002.trading.strategy.StrategyPair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Trader {

    private final Map<Chart, StrategyPair> strategyPairMap;
    private final List<Trade> pastTrades = new ArrayList<>();
    private double fund;
    private Trade currentTrade;

    public Trader(Chart chart, StrategyPair strategyPair) {
        this(Map.of(chart, strategyPair));
    }

    public Trader(Map<Chart, StrategyPair> strategyPairMap) {
        if (strategyPairMap.isEmpty()) {
            throw new IllegalArgumentException("Not chart for trading");
        }
        this.strategyPairMap = strategyPairMap;
    }

    public void trade(double startFund, int startDayIndex) {
        fund = startFund;
        currentTrade = null;

        for (int index = startDayIndex; index < strategyPairMap.keySet().iterator().next().getPeriods(); index++) {
            if (currentTrade == null) { // check for buy
                for (var chart : strategyPairMap.keySet()) {
                    var buyStrategy = strategyPairMap.get(chart).getBuyStrategy();
                    if (buyStrategy.shouldTakeAction(this, chart, index)) {
                        double price = buyStrategy.decidePrice(chart, index);
                        int share = (int) (fund / price);
                        fund -= share * price;
                        currentTrade = new Trade(chart, index, price, share);
                        break;
                    }
                }
            } else { // check for sell
                var chart = currentTrade.getChart();
                var sellStrategy = strategyPairMap.get(chart).getSellStrategy();
                if (sellStrategy.shouldTakeAction(this, chart, index)) {
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

    @Override
    public String toString() {
        return String.format("Trade: %d, Fund: %.2f, Betting Average: %.2f, Win Loss Ratio: %.2f",
                pastTrades.size(), lastFund(), getBettingAverage(), getWinLossRatio());
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

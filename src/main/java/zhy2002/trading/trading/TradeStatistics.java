package zhy2002.trading.trading;

import lombok.Getter;
import zhy2002.trading.Trade;

import java.util.Collection;
import java.util.stream.Collectors;


@Getter
public final class TradeStatistics {

    private final Collection<Trade> trades;
    private final Collection<Trade> completedTrades;
    private final double bettingAverage;
    private final double winLossRatio;
    private final double expectedProfit;

    public TradeStatistics(Collection<Trade> trades) {
        this.trades = trades;
        completedTrades = trades.stream().filter(Trade::isComplete).collect(Collectors.toList());
        bettingAverage = computeBettingAverage(completedTrades);
        winLossRatio = computeWinLossRatio(completedTrades);
        expectedProfit = computeExpectedProfit(completedTrades);
    }

    public static double computeBettingAverage(Collection<Trade> trades) {
        double winCount = 0;
        double completeCount = 0;
        for (var t : trades) {
            if (!t.isComplete()) {
                continue;
            }
            if (t.getBuyPrice() < t.getSellPrice()) {
                winCount++;
            }
            completeCount++;
        }
        return winCount / completeCount;
    }

    public static double computeWinLossRatio(Collection<Trade> trades) {
        double winPercent = 0;
        int winCount = 0;
        double lossPercent = 0;
        int lossCount = 0;
        for (var t : trades) {
            if (!t.isComplete()) {
                continue;
            }
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

    public static double computeExpectedProfit(Collection<Trade> completedTrades) {
        return completedTrades.stream().filter(Trade::isComplete)
                .mapToDouble(t -> (t.getSellPrice() - t.getBuyPrice()) / t.getBuyPrice())
                .average().orElse(Double.NaN);
    }

    public double getCompoundProfit() {
        return Math.pow(1 + getExpectedProfit(), getCompletedTrades().size());
    }

    @Override
    public String toString() {
        return String.format("Trade: %d, Complete Trade; %d, Betting Average: %.2f, Win Loss Ratio: %.2f, Expected Profit: %.2f, Compound Profit: %.2f",
                getTrades().size(), getCompletedTrades().size(), getBettingAverage(), getWinLossRatio(), getExpectedProfit(), getCompoundProfit());
    }
}

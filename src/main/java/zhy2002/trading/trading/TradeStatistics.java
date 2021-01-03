package zhy2002.trading.trading;

import lombok.Getter;
import zhy2002.trading.Trade;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;


public final class TradeStatistics {

    public static final String COMPLETED_TRADES = "Completed Trades";
    public static final String MEAN_PROFIT = "Mean Profit";
    public static final String MIN_PROFIT = "Min Profit";
    public static final String MAX_HOLD_DAYS = "Max Hold Days";
    public static final String MIN_HOLD_DAYS = "Min Hold Days";
    public static final String BETTING_AVERAGE = "Betting Average";
    public static final String WIN_LOSS_RATIO = "Win Loss Ratio";
    public static final String COMP_PROFIT = "Comp Profit";
    public static final String DRAW_DOWN = "Draw down";

    @Getter
    private final Collection<Trade> trades;
    @Getter
    private final Collection<Trade> completedTrades;
    private final Map<String, Object> data = new TreeMap<>();

    public TradeStatistics(Collection<Trade> trades) {
        this.trades = trades;
        completedTrades = trades.stream().filter(Trade::isComplete).collect(Collectors.toList());
        data.put(COMPLETED_TRADES, completedTrades.size());
        double expProfit = computeExpectedProfit(completedTrades);
        data.put(MEAN_PROFIT, expProfit);
        data.put(MIN_PROFIT, profitStream(completedTrades).min().orElse(Double.NaN));
        data.put(BETTING_AVERAGE, computeBettingAverage(completedTrades));
        data.put(WIN_LOSS_RATIO, computeWinLossRatio(completedTrades));
        data.put(COMP_PROFIT, Math.pow(1 + expProfit, getCompletedTrades().size()));
        data.put(MAX_HOLD_DAYS, completedTrades.stream().mapToInt(t -> t.getSellDayIndex() - t.getBuyDayIndex()).max().orElse(0));
        data.put(MIN_HOLD_DAYS, completedTrades.stream().mapToInt(t -> t.getSellDayIndex() - t.getBuyDayIndex()).min().orElse(0));
        data.put(DRAW_DOWN, completedTrades.stream().mapToDouble(Trade::getDrawDown).max().orElse(Double.NaN));
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
        double result = winPercent / lossPercent;
//        if (Double.isInfinite(result)) {
//            System.out.print("what");
//        }
        return result;
    }

    public static double computeExpectedProfit(Collection<Trade> completedTrades) {
        return profitStream(completedTrades).average().orElse(Double.NaN);
    }

    private static DoubleStream profitStream(Collection<Trade> completedTrades) {
        return completedTrades.stream().filter(Trade::isComplete)
                .mapToDouble(t -> (t.getSellPrice() - t.getBuyPrice()) / t.getBuyPrice());
    }

    @Override
    public String toString() {
        return String.format("Trade: %d, Complete Trade; %d, Betting Average: %.2f, Win Loss Ratio: %.2f, Expected Profit: %.2f, Compound Profit: %.2f",
                getTrades().size(), getCompletedTrades().size(), getBettingAverage(), getWinLossRatio(), getMeanProfit(), getCompoundProfit());
    }

    public Object getData(String colName) {
        return data.get(colName);
    }

    public double getBettingAverage() {
        return (double) getData(BETTING_AVERAGE);
    }

    public double getWinLossRatio() {
        return (double) getData(WIN_LOSS_RATIO);
    }

    public double getCompoundProfit() {
        return (double) getData(COMP_PROFIT);
    }

    public double getMeanProfit() {
        return (double) getData(MEAN_PROFIT);
    }
}

package zhy2002.trading.trading;

import lombok.Getter;
import zhy2002.trading.Trade;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


public final class TradeStatistics {

    public static final String COMPLETED_TRADES = "Completed Trades";
    public static final String MEAN_PROFIT = "Mean Profit";
    public static final String MIN_PROFIT = "Min Profit";
    public static final String MAX_HOLD_DAYS = "Max Hold Days";
    public static final String MIN_HOLD_DAYS = "Min Hold Days";
    public static final String BETTING_AVERAGE = "Betting Average";
    public static final String WIN_LOSS_RATIO = "Win Loss Ratio";
    public static final String DRAW_DOWN = "Draw down";
    public static final String AVERAGE_WIN = "Average Win";
    public static final String AVERAGE_LOSS = "Average Loss";

    @Getter
    private final Collection<Trade> trades;
    @Getter
    private final Collection<Trade> completedTrades;
    private final Map<String, Object> data = new TreeMap<>();

    public TradeStatistics(Collection<Trade> trades) {
        this.trades = trades;
        completedTrades = trades.stream().filter(Trade::isComplete).collect(Collectors.toList());
        data.put(COMPLETED_TRADES, completedTrades.size());

        double winPercent = 0;
        int winCount = 0;
        double lossPercent = 0;
        int lossCount = 0;
        double minProfit = Double.NaN;
        for (var t : completedTrades) {
            var p = (t.getSellPrice() - t.getBuyPrice()) / t.getBuyPrice();
            if (p > 0) {
                winPercent += p;
                winCount++;
            } else {
                lossPercent += -p;
                lossCount++;
            }
            if (Double.isNaN(minProfit) || p < minProfit) {
                minProfit = p;
            }
        }
        data.put(MEAN_PROFIT, (winPercent - lossPercent) / (winCount + lossCount));
        data.put(MIN_PROFIT, minProfit);
        data.put(AVERAGE_WIN, winPercent / winCount);
        data.put(AVERAGE_LOSS, lossPercent / lossCount);
        data.put(BETTING_AVERAGE, (double) winCount / completedTrades.size());
        data.put(WIN_LOSS_RATIO, (winPercent / winCount) / (lossPercent / lossCount));

        data.put(MAX_HOLD_DAYS, completedTrades.stream().mapToInt(t -> t.getSellDayIndex() - t.getBuyDayIndex()).max().orElse(0));
        data.put(MIN_HOLD_DAYS, completedTrades.stream().mapToInt(t -> t.getSellDayIndex() - t.getBuyDayIndex()).min().orElse(0));
        data.put(DRAW_DOWN, completedTrades.stream().mapToDouble(Trade::getDrawDown).max().orElse(Double.NaN));
    }

    @Override
    public String toString() {
        return String.format("Trade: %d, Complete Trade; %d, Betting Average: %.4f, Win Loss Ratio: %.4f, Expected Profit: %.4f, DrawDown: %4f",
                getTrades().size(), getCompletedTrades().size(), getBettingAverage(), getWinLossRatio(), getMeanProfit(), getDrawDown());
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

    public double getMeanProfit() {
        return (double) getData(MEAN_PROFIT);
    }

    public double getAverageWin() {
        return (double) getData(AVERAGE_WIN);
    }

    public double getAverageLoss() {
        return (double) getData(AVERAGE_LOSS);
    }

    public int getCompletedCount() {
        return completedTrades.size();
    }

    public double getDrawDown() {
        return (double) getData(DRAW_DOWN);
    }
}

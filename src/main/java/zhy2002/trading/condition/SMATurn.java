package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.trading.Trader;

public class SMATurn implements TradeCondition {

    private final int smaPeriods;
    private final int downWindow;
    private final int upWindow;
    private final double downRate;

    public SMATurn(int smaPeriods, int downWindow, int upWindow, double downRate) {
        this.smaPeriods = smaPeriods;
        this.downWindow = downWindow;
        this.upWindow = upWindow;
        this.downRate = downRate;
    }

    public boolean isMet(Trader trader, Chart chart, int index) {
        if (!checkCondition(chart, index)) {
            return false;
        }

        return true; //lastTimeIsOk(trader, index);
    }

//    // if last time lost money, cool down 10 days
//    private boolean lastTimeIsOk(Trader trader, int nowIndex) {
//        if (trader.getTrades().isEmpty()) {
//            return true;
//        }
//        var lastTrade = trader.getTrades().get(trader.getTrades().size() - 1);
//        return lastTrade.getSellDayIndex() <= nowIndex - 10 || lastTrade.getSellPrice() > lastTrade.getBuyPrice();
//    }

    private boolean checkCondition(Chart chart, int index) {
        var sma = chart.getSMA(smaPeriods);
        double downPercent = 0;
        int downCount = 0;
        for (int i = index - upWindow - downWindow + 1; i <= index - upWindow; i++) {
            var p = (chart.getCandle(i).getClose() - sma.get(i)) / sma.get(i);
            downPercent += p;
            if (p < 0) {
                downCount++;
            }
        }
        downPercent /= downWindow;
        if (downPercent >= downRate || downCount < 0) {
            return false;
        }

        double upPercent = 0;
        for (int i = index - upWindow + 1; i <= index; i++) {
            upPercent += (chart.getCandle(i).getClose() - sma.get(i)) / sma.get(i);
        }
        upPercent /= upWindow;
        return upPercent > 0;
    }

}

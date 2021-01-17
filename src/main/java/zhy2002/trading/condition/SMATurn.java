package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class SMATurn extends ChartTradeCondition {

    private final int smaPeriods;
    private final int downWindow;
    private final int upWindow;
    private final double downRate;
    private final double upRate;

    @Override
    public boolean isMet(Chart chart, int index) {
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
        return upPercent >= upRate;
    }

}

package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public class BullishEngulfing implements TradeCondition {

    @Override
    public boolean isMet(Chart chart, int index) {
        var current = chart.getCandle(index);
        // not price rise
        if (current.getClose() < current.getOpen()) {
            return false;
        }
        var atr = chart.getATR();
        // this candle is not large enough
        if (current.getClose() - current.getOpen() < atr.get(index - 1) * 0.3) {
            return false;
        }

        var previous = chart.getCandle(index - 1);
        // not price drop
        if (previous.getClose() > previous.getOpen()) {
            return false;
        }

        // previous candle is not large enough
        if (previous.getOpen() - previous.getClose() < atr.get(index - 2) * 0.3) {
            return false;
        }

        // engulfing
        return current.getOpen() <= previous.getClose() && current.getClose() > previous.getOpen()
                && (current.getClose() - current.getOpen()) >= 1.5 * (previous.getOpen() - previous.getClose());
    }
}

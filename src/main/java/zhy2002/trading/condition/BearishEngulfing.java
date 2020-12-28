package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public class BearishEngulfing implements TradeCondition {

    @Override
    public boolean isMet(Chart chart, int index) {
        var current = chart.getCandle(index);
        // not price drop
        if (current.getClose() > current.getOpen()) {
            return false;
        }
        var atr = chart.getATR();
        // this candle is large enough
        if (current.getOpen() - current.getClose() < atr.get(index - 1) * 0.3) {
            return false;
        }

        var previous = chart.getCandle(index - 1);
        // not price rise
        if (previous.getClose() < previous.getOpen()) {
            return false;
        }

        // previous candle is large enough
        if (previous.getClose() - previous.getOpen() < atr.get(index - 2) * 0.3) {
            return false;
        }

        // engulfing
        return current.getOpen() >= previous.getClose() && current.getClose() < previous.getOpen()
                && (current.getOpen() - current.getClose()) >= 1.5 * (previous.getClose() - previous.getOpen());
    }
}

package zhy2002.trading.condition;

import zhy2002.trading.Chart;


public class SMATurn implements TradeCondition {

    public boolean isMet(Chart chart, int index) {
        var candle = chart.getCandle(index);
        // must be up
        if (candle.getOpen() >= candle.getClose()) {
            return false;
        }

        var sma5 = chart.getSMA(5);
        // high must cross sma(5)
        if (sma5.get(index) > candle.getHigh() || sma5.get(index) < candle.getLow()) {
            return false;
        }

        // previous 3 days close below sma(5)
        for (int i = 1; i <= 3; i++) {
            if (chart.getCandle(index - i).getClose() >= sma5.get(index - i)) {
                return false;
            }
        }

        // in the past 3 days prices dropped 5%
        var sma14 = chart.getSMA(14);
        var refPoint = sma14.get(index - 3);
        if ((sma14.get(index) - refPoint) / refPoint <= -0.04) {
            return false;
        }

        // close at or higher than previous sma 14
        if (candle.getClose() >= sma14.get(index - 1)) {
            return false;
        }

        return true;
    }

}

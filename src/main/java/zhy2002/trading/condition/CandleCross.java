package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.adaptor.SMAArrayExtractor;

public class CandleCross extends ChartTradeCondition {

    public boolean isMet(Chart chart, int index) {
        var sma50 = chart.getSMA(50);
        var extractor = new SMAArrayExtractor(50, 10);
        if (RegressionTrend.linearRegressionK(extractor.extract(chart, index)) <= 0) {
            return false;
        }

        var extractor2 = new SMAArrayExtractor(5, 5);
        if (RegressionTrend.linearRegressionK(extractor2.extract(chart, index)) <= 0) {
            return false;
        }

        var candle = chart.getCandle(index);
        if (candle.getClose() < candle.getOpen()) {
            return false;
        }

        var s = sma50.get(index);
        var c = candle.getClose();
        return c >= s && c <= s * 1.01;
    }
}

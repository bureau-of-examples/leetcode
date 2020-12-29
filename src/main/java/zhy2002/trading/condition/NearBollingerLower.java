package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public class NearBollingerLower implements TradeCondition {

    @Override
    public boolean isMet(Chart chart, int index) {
        var atr = chart.getATR();
        var band = chart.getBollingerBand();
        var candle = chart.getCandle(index);
        return candle.getClose() < band.getLower(index - 1) + atr.get(index - 1) * 0.5;
    }
}

package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public class NearBollingerLower implements TradeCondition {

    private final double atrRatio;

    public NearBollingerLower() {
        this(0);
    }

    public NearBollingerLower(double atrRatio) {
        this.atrRatio = atrRatio;
    }

    @Override
    public boolean isMet(Chart chart, int index) {
        var atr = chart.getATR();
        var band = chart.getBollingerBand();
        var candle = chart.getCandle(index);
        return candle.getClose() < band.getLower(index - 1) - atr.get(index - 1) * atrRatio;
    }
}

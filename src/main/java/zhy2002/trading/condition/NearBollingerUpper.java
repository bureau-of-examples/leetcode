package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public class NearBollingerUpper implements TradeCondition {

    private final double atrRatio;

    public NearBollingerUpper() {
        this(0);
    }

    public NearBollingerUpper(double atrRatio) {
        this.atrRatio = atrRatio;
    }

    @Override
    public boolean isMet(Chart chart, int index) {
        var atr = chart.getATR();
        var band = chart.getBollingerBand();
        var candle = chart.getCandle(index);
        return candle.getClose() > band.getUpper(index - 1) + atr.get(index - 1) * atrRatio;
    }
}

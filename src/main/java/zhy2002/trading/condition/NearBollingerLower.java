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
        for (int i = 0; i < 1; i++) {
            if (chart.getCandle(index - i).getClose() > band.getLower(index - i - 1) - atr.get(index - i - 1) * atrRatio) {
                return false;
            }
        }
        return true;
    }
}

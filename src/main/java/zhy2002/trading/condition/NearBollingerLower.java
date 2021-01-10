package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class NearBollingerLower implements TradeCondition {

    private final int periods;
    private final double atrRatio;
    private final int window;

    public NearBollingerLower(double atrRatio) {
        this(20, atrRatio, 1);
    }

    public NearBollingerLower() {
        this(0);
    }

    @Override
    public boolean isMet(Chart chart, int index) {
        var atr = chart.getATR();
        var band = chart.getBollingerBand(periods);
        for (int i = 0; i < window; i++) {
            if (chart.getCandle(index - i).getClose() > band.getLower(index - i) + atr.get(index - i) * atrRatio) {
                return false;
            }
        }
        return true;
    }
}

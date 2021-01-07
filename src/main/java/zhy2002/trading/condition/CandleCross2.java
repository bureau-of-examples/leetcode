package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public class CandleCross2 implements TradeCondition {

    public boolean isMet(Chart chart, int index) {
        var sma20 = chart.getSMA(20);
        if (sma20.get(index) > sma20.get(index - 1)) {
            return false;
        }
        for (int i=1; i<=3; i++) {
            if (sma20.get(index - i - 1) - sma20.get(index - i) > 0) {
                return false;
            }
        }
        return true;
    }
}

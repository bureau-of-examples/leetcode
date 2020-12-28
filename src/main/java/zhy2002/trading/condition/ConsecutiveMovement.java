package zhy2002.trading.condition;

import lombok.AllArgsConstructor;
import zhy2002.trading.Candle;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class ConsecutiveMovement implements TradeCondition {

    private final Comparison comparison;
    private final int times;


    @Override
    public boolean isMet(Chart chart, int index) {
        if (index < times) {
            throw new IllegalArgumentException("Invalid index " + index);
        }
        for (int i = 1; i <= times; i++) {
            Candle current = chart.getCandle(index - i + 1);
            Candle previous = chart.getCandle(index - i);
            if (!comparison.isTrue(current.getClose(), previous.getClose())) {
                return false;
            }
        }
        return true;
    }
}

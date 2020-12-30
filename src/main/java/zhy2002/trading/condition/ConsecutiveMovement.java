package zhy2002.trading.condition;

import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import zhy2002.trading.Candle;
import zhy2002.trading.Chart;

@AllArgsConstructor
public class ConsecutiveMovement implements TradeCondition {

    private final Comparison comparison;
    private final int times;

    public ConsecutiveMovement(Comparison comparison) {
        this(comparison, 2);
    }

    @Override
    public boolean isMet(Chart chart, int index) {
        Preconditions.checkArgument(index >= times, "Invalid index %s", index);

        for (int i = 0; i < times; i++) {
            Candle current = chart.getCandle(index - i);
            Candle previous = chart.getCandle(index - i - 1);
            if (!comparison.isTrue(current.getClose(), previous.getClose())) {
                return false;
            }
        }
        return true;
    }
}

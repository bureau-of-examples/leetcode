package zhy2002.trading.data;

import lombok.AllArgsConstructor;
import zhy2002.trading.Candle;

import java.util.List;

@AllArgsConstructor
public class ClosePriceProvider implements ValueProvider {

    private final List<Candle> candles;

    @Override
    public double get(int i) {
        return candles.get(i).getClose();
    }

    @Override
    public int length() {
        return candles.size();
    }
}

package zhy2002.trading.data;

import lombok.AllArgsConstructor;
import zhy2002.trading.Candle;

import java.util.List;

@AllArgsConstructor
public class OpenPriceProvider implements ValueProvider {

    private final List<Candle> candles;

    @Override
    public double get(int i) {
        return candles.get(i).getOpen();
    }

    @Override
    public int length() {
        return candles.size();
    }
}

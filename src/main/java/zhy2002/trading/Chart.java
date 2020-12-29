package zhy2002.trading;

import zhy2002.trading.csv.CsvDataLoader;
import zhy2002.trading.indicator.ATR;
import zhy2002.trading.indicator.BollingerBand;
import zhy2002.trading.indicator.RSI;
import zhy2002.trading.indicator.SMA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Chart {

    private static final CsvDataLoader CSV_DATA_LOADER = new CsvDataLoader();

    private final Map<Integer, SMA> smaMap = new HashMap<>();
    private final Map<Integer, ATR> atrMap = new HashMap<>();
    private final Map<Integer, BollingerBand> bandMap = new HashMap<>();
    private final Map<Integer, RSI> rsiMap = new HashMap<>();


    private final String symbol;
    private final List<Candle> candles;


    public Chart(String symbol) {
        this.symbol = symbol;
        this.candles = CSV_DATA_LOADER.readCandles(symbol);
    }

    public String getSymbol() {
        return symbol;
    }

    public Candle getCandle(int index) {
        return candles.get(index);
    }

    public int getPeriods() {
        return candles.size();
    }

    public SMA getSMA(int smaPeriods) {
        return smaMap.computeIfAbsent(smaPeriods, (p) -> new SMA(this, p));
    }

    public ATR getATR(int atrPeriods) {
        return atrMap.computeIfAbsent(atrPeriods, (p) -> new ATR(this, p));
    }

    public ATR getATR() {
        return getATR(14);
    }

    public RSI getRSI() {
        return rsiMap.computeIfAbsent(14, p -> new RSI(this, p));
    }

    public BollingerBand getBollingerBand() {
        return bandMap.computeIfAbsent(20, p -> new BollingerBand(this, p));
    }

    public int findDateIndex(String startDate) {
        for (int i = 0; i < candles.size(); i++) {
            if (getCandle(i).getDate().compareTo(startDate) >= 0) {
                return i;
            }
        }
        return -1;
    }
}

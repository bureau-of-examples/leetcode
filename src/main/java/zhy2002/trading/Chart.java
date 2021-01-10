package zhy2002.trading;

import lombok.Getter;
import zhy2002.trading.csv.CsvDataLoader;
import zhy2002.trading.data.ClosePriceProvider;
import zhy2002.trading.data.HighPriceProvider;
import zhy2002.trading.data.LowPriceProvider;
import zhy2002.trading.data.OpenPriceProvider;
import zhy2002.trading.indicator.ATR;
import zhy2002.trading.indicator.AboveBelowRate;
import zhy2002.trading.indicator.BollingerBand;
import zhy2002.trading.indicator.DonchianChannel;
import zhy2002.trading.indicator.EATR;
import zhy2002.trading.indicator.EMA;
import zhy2002.trading.indicator.RSI;
import zhy2002.trading.indicator.SMA;
import zhy2002.trading.indicator.Stochastic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Chart {

    private static final CsvDataLoader CSV_DATA_LOADER = new CsvDataLoader();

    // todo clean this mess up
    private final Map<Integer, ATR> atrMap = new HashMap<>();
    private final Map<Integer, BollingerBand> bbMap = new HashMap<>();
    private final Map<Integer, DonchianChannel> dcMap = new HashMap<>();
    private final Map<Integer, EATR> eatrMap = new HashMap<>();
    private final Map<Integer, EMA> emaMap = new HashMap<>();
    private final Map<Integer, RSI> rsiMap = new HashMap<>();
    private final Map<Integer, SMA> smaMap = new HashMap<>();
    private final Map<Integer, Stochastic> stMap = new HashMap<>();
    private final Map<String, AboveBelowRate> smaAbrMap = new HashMap<>();


    @Getter
    private final String symbol;
    @Getter
    private final OpenPriceProvider openPriceProvider;
    @Getter
    private final ClosePriceProvider closePriceProvider;
    @Getter
    private final HighPriceProvider highPriceProvider;
    @Getter
    private final LowPriceProvider lowPriceProvider;

    private final List<Candle> candles;


    public Chart(String symbol) {
        this.symbol = symbol;
        this.candles = CSV_DATA_LOADER.readCandles(symbol);
        this.openPriceProvider = new OpenPriceProvider(candles);
        this.closePriceProvider = new ClosePriceProvider(candles);
        this.highPriceProvider = new HighPriceProvider(candles);
        this.lowPriceProvider = new LowPriceProvider(candles);
    }

    public Candle getCandle(int index) {
        return candles.get(index);
    }

    public int getPeriods() {
        return candles.size();
    }

    public int findDateIndex(String startDate) {
        for (int i = 0; i < candles.size(); i++) {
            if (getCandle(i).getDate().compareTo(startDate) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public double getTr(int i) {
        var current = getCandle(i);
        var previous = getCandle(i - 1);
        return Math.max(
                Math.max(current.getHigh() - current.getLow(), Math.abs(current.getHigh() - previous.getClose())),
                Math.abs(current.getLow() - previous.getClose()));

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
        return getBollingerBand(20);
    }

    public BollingerBand getBollingerBand(int bbPeriods) {
        return bbMap.computeIfAbsent(bbPeriods, p -> new BollingerBand(this, p));
    }

    public DonchianChannel getDonchianChannel() {
        return getDonchianChannel(20);
    }

    public DonchianChannel getDonchianChannel(int periods) {
        return dcMap.computeIfAbsent(periods, p -> new DonchianChannel(this, p));
    }

    public EMA getEMA(int periods) {
        return emaMap.computeIfAbsent(periods, p -> new EMA(this, p));
    }

    public Stochastic getStochastic() {
        return getStochastic(14);
    }

    public Stochastic getStochastic(int periods) {
        return stMap.computeIfAbsent(periods, p -> new Stochastic(this, p, 3, 3));
    }

    public EATR getEATR() {
        return getEATR(14);
    }

    public EATR getEATR(int periods) {
        return eatrMap.computeIfAbsent(periods, p -> new EATR(this, p));
    }

    public AboveBelowRate getSMAAboveBelowRate(int periods, int window) {
        return smaAbrMap.computeIfAbsent(String.format("%d,%d", periods, window), p -> new AboveBelowRate(getClosePriceProvider(), getSMA(periods), window));
    }
}

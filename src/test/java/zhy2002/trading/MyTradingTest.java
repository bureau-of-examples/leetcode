package zhy2002.trading;

import org.junit.Test;
import zhy2002.trading.csv.CsvDataLoader;
import zhy2002.trading.strategy.CrossMa;

import java.util.List;


public class MyTradingTest {

    @Test
    public void testCrossMa() {
        String[] symbols = new String[]{"AGL.AX", "BHP.AX", "CBA.AX", "SCG.AX", "WES.AX", "WOW.AX", "WPL.AX"};
        int[] periodsArray = new int[]{20, 50, 100, 150, 200};
        for (String symbol : symbols) {
            for (int maPeriods : periodsArray) {
                runCrossMa(symbol, maPeriods);
            }
        }
    }

    private void runCrossMa(String symbol, int maPeriods) {
        CsvDataLoader csvDataLoader = new CsvDataLoader();
        List<Candle> candles = csvDataLoader.readCandles(symbol);
        CrossMa crossMa = new CrossMa(maPeriods);
        crossMa.run(10_000, candles, maPeriods);
        System.out.printf("Tested %s with %s\n", symbol, crossMa);
    }

}

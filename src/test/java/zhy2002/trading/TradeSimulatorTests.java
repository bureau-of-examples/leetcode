package zhy2002.trading;


import org.junit.Test;

public class TradeSimulatorTests {

    private final TradeSimulator tradeSimulator = new TradeSimulator();

    @Test
    public void simulateBHP() {
        tradeSimulator.simulateBHP();
    }

    @Test
    public void simulate1Test() {
        tradeSimulator.simulate1();
    }

    @Test
    public void simulateMultiple() {
        tradeSimulator.simulateMultiple();
    }

//    @Test
//    public void testCrossMa() {
////        String[] symbols = new String[]{"AGL.AX", "BHP.AX", "CBA.AX", "SCG.AX", "WES.AX", "WOW.AX", "WPL.AX"};
////        int[] periodsArray = new int[]{20, 50, 100, 150, 200};
////        for (String symbol : symbols) {
////            for (int maPeriods : periodsArray) {
////                runCrossMa(symbol, maPeriods);
////            }
////        }
//        runCrossMa("SCG.AX", 100);
//    }
//
//    private void runCrossMa(String symbol, int maPeriods) {
//        CsvDataLoader csvDataLoader = new CsvDataLoader();
//
//
//    }

}

package zhy2002.trading;


import org.junit.Test;
import zhy2002.trading.test.BollingerBandSetup;
import zhy2002.trading.test.RandomSetup;
import zhy2002.trading.test.SMABounceSetup;

public class BackTesterTest {

    private final BackTester backTester = new BackTester();

    @Test
    public void randomTest() {
        backTester.backTest(new RandomSetup());
    }

    @Test
    public void smaBounceTest() {
        backTester.backTest(new SMABounceSetup());
    }

    @Test
    public void bollingerBandTest() {
        backTester.backTest(new BollingerBandSetup());
    }

}
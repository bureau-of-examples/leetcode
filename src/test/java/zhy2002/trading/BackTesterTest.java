package zhy2002.trading;


import org.junit.Test;
import zhy2002.trading.test.BollingerBandSetup;
import zhy2002.trading.test.CrossSMASetup;
import zhy2002.trading.test.RandomSetup;
import zhy2002.trading.test.SMABounceSetup;
import zhy2002.trading.test.CloseAboveSMARateSetup;
import zhy2002.trading.test.SMATurnSetup;

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

    @Test
    public void closeAboveSMARateTest() {
        backTester.backTest(new CloseAboveSMARateSetup());
    }

    @Test
    public void crossSMATest() {
        backTester.backTest(new CrossSMASetup());
    }

    @Test
    public void smaTurnTest() {
        backTester.backTest(new SMATurnSetup());
    }

}
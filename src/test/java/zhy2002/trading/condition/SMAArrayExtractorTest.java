package zhy2002.trading.condition;


import org.junit.Test;

public class SMAArrayExtractorTest {

    @Test
    public void regressionTest() {
        System.out.println(RegressionTrend.linearRegressionK(new double[]{1, 2, 3, 4, 5}));
        System.out.println(RegressionTrend.linearRegressionK(new double[]{10, 20, 30, 40, 50}));
        System.out.println(RegressionTrend.linearRegressionK(new double[]{11, 32, 44, 12, 45, 22, 13}));
        System.out.println(RegressionTrend.linearRegressionK(new double[]{21, 17, 44, 12, 45, 34, 57}));
    }

}
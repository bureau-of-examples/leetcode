package zhy2002.trading.condition;


import org.junit.Test;

public class SMATrendTest {

    @Test
    public void regressionTest() {
        System.out.println(SMATrend.linearRegressionK(new double[]{0, 1, 2, 3, 4}));
        System.out.println(SMATrend.linearRegressionK(new double[]{11, 32, 44, 12, 45, 22, 13}));
        System.out.println(SMATrend.linearRegressionK(new double[]{21, 17, 44, 12, 45, 34, 57}));
    }

}
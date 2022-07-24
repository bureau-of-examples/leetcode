package zhy2002.trading.data;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NormalizedSlopeProviderTest {

    @Test
    public void resultIsCorrect() {
        double[] result = NormalizedSlopeProvider.compute(new ArrayValueProvider(new double[]{1, 1.03, 1.05, 1.07, 1.1}), 5);
        System.out.println(result[0]);
        assertThat(String.format("%.4f", result[0]), equalTo("0.0240"));

        result = NormalizedSlopeProvider.compute(new ArrayValueProvider(new double[]{1, 1.03, 1.04, 1.07, 1.05, 1.1, 1.08}), 7);
        System.out.println(result[0]);
        assertThat(String.format("%.4f", result[0]), equalTo("0.0139"));

        result = NormalizedSlopeProvider.compute(new ArrayValueProvider(new double[]{1, 1.03, 1.1, 0.91, 0.82, 0.81, 0.75, 0.78, 0.75}), 9);
        System.out.println(result[0]);
        assertThat(String.format("%.4f", result[0]), equalTo("-0.0425"));

    }
}

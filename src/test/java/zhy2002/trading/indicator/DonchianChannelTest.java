package zhy2002.trading.indicator;

import org.junit.Test;
import zhy2002.trading.Chart;
import zhy2002.trading.adaptor.ClosePriceArrayExtractor;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DonchianChannelTest {

    @Test
    public void test() {
        var chart = new Chart("NAB.AX");
        int window = 10;
        var dc = new DonchianChannel(chart, window);
        var extractor = new ClosePriceArrayExtractor(window);

        for (int i = 9; i < 50; i++) {
            var min = dc.getLower(i);
            var max = dc.getUpper(i);
            var array = extractor.extract(chart, i);
            assertThat(max, equalTo(Arrays.stream(array).max().orElse(Double.NaN)));
            assertThat(min, equalTo(Arrays.stream(array).min().orElse(Double.NaN)));
        }
    }
}

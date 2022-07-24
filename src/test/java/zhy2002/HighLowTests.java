package zhy2002;

import org.junit.Test;
import zhy2002.trading.Chart;
import zhy2002.trading.HighLow;


public class HighLowTests {

    @Test
    public void test() {
        var chart = new Chart("NAB.AX");
        var highLow = new HighLow(chart.getClosePriceProvider(), 50);
        System.out.println("Highs:");
        printDates(chart, highLow.getHighIndices());
        System.out.println("Lows:");
        printDates(chart, highLow.getLowIndices());
    }

    private void printDates(Chart chart, Iterable<Integer> highIndices) {
        for (var i : highIndices) {
            System.out.println(chart.getCandle(i).getDate());
        }
    }
}

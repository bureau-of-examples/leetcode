package zhy2002.trading.trading;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;
import zhy2002.trading.Chart;
import zhy2002.trading.Trade;
import zhy2002.trading.strategy.StrategyGenerator;
import zhy2002.trading.strategy.StrategyPair;

public class TradeGeneratorTest {

    @Test
    public void test() {
        var chart = new Chart("CBA.AX");
        var generator = new StrategyGenerator();
//        var bList = generator.buyBollingerBand(new double[]{-0.9, -0.7, -0.5, -0.3}, new int[]{-10, -8, -6, -4});
//        var sList = generator.sellBollingerBand(new double[]{0.1, 0.2, 0.3}, new int[]{1, 2, 3});
        var bList = generator.buyBelowSMAWithMovement(new int[]{50, 100}, new int[]{2, 3, 4});
        var sList = generator.sellAboveSMAWithMovement(new int[]{50, 100}, new int[]{2, 3, 4});
        for (var b : bList) {
            for (var s : sList) {
                var strategyPair = new StrategyPair(b, s);
                var tradeGenerator = new TradeGenerator();
                var result = tradeGenerator.generate(chart, strategyPair, "2016-01-01");

                Multimap<String, Trade> byYear = ArrayListMultimap.create();
                for (var t : result) {
                    byYear.put(chart.getCandle(t.getBuyDayIndex()).getDate().substring(0, 4), t);
                }
                System.out.printf("Result for %s and %s:%n", b, s);
                for (int i = 2016; i <= 2020; i++) {
                    var stat = new TradeStatistics(byYear.get(String.valueOf(i)));
                    System.out.printf("===>Year: %d, %s%n", i, stat);
                }
            }
        }


    }

}
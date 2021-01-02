package zhy2002.trading.csv;

import lombok.AllArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static zhy2002.trading.trading.TradeStatistics.BETTING_AVERAGE;
import static zhy2002.trading.trading.TradeStatistics.COMPLETED_TRADES;
import static zhy2002.trading.trading.TradeStatistics.MAX_HOLD_DAYS;
import static zhy2002.trading.trading.TradeStatistics.MEAN_PROFIT;
import static zhy2002.trading.trading.TradeStatistics.MIN_HOLD_DAYS;
import static zhy2002.trading.trading.TradeStatistics.MIN_PROFIT;
import static zhy2002.trading.trading.TradeStatistics.WIN_LOSS_RATIO;

@AllArgsConstructor
public class ResultCsv {

    private final String[] STAT_HEADERS = new String[]{
            COMPLETED_TRADES, MEAN_PROFIT, MIN_PROFIT, MAX_HOLD_DAYS, MIN_HOLD_DAYS,
            BETTING_AVERAGE, WIN_LOSS_RATIO};

    private final int startYear;
    private final int endYear;
    private final List<ResultCsvRow> resultCsvRows;

    public void writeToFile() {
        try (var fileWriter = new FileWriter("strategy_results.csv"); var printWriter = new PrintWriter(fileWriter)) {
            // write header row
            printWriter.print("Group,Symbol,Buy Strategy,SellStrategy,Last Fund");
            for (var colName : STAT_HEADERS) {
                for (int year = startYear; year <= endYear; year++) {
                    printWriter.printf(", %d %s", year, colName);
                }
            }
            printWriter.println();

            // write data rows
            for (var row : resultCsvRows) {
                printWriter.printf("%s,%s,\"%s\",\"%s\",%.4f",
                        row.getGroup(), row.getSymbol(), row.getBuyStrategy(), row.getSellStrategy(), row.getLastFund());
                for (var colName : STAT_HEADERS) {
                    for (int year = startYear; year <= endYear; year++) {
                        var obj = row.getData(year, colName);
                        appendToRow(printWriter, obj);
                    }
                }
                printWriter.println();
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void appendToRow(PrintWriter printWriter, Object obj) {
        if (obj instanceof Double) {
            printWriter.printf(",%.4f", obj);
        } else {
            printWriter.printf(",%s", obj);
        }
    }
}

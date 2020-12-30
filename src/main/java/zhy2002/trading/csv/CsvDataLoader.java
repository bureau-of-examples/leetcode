package zhy2002.trading.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import zhy2002.trading.Candle;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads files downloaded from https://au.finance.yahoo.com/
 */
public class CsvDataLoader {

    public List<Candle> readCandles(String symbol) {
        List<Candle> result = new ArrayList<>();
        try (
                InputStream inputStream = this.getClass().getResourceAsStream(symbol.toUpperCase() + ".csv");
                Reader reader = new InputStreamReader(inputStream)
        ) {
            // https://commons.apache.org/proper/commons-csv/user-guide.html
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord record : records) {
                String date = record.get("Date");
                double open = Double.parseDouble(record.get("Open"));
                double high = Double.parseDouble(record.get("High"));
                double low = Double.parseDouble(record.get("Low"));
                double close = Double.parseDouble(record.get("Close"));
                double volume = Double.parseDouble(record.get("Volume"));
                result.add(new Candle(date, open, high, low, close, volume));
            }
        } catch (IOException ex) {
            throw new RuntimeException("Failed to parse csv file: ", ex);
        }
        return result;
    }
}
/* todo load daily automatically:
○ → curl "https://query1.finance.yahoo.com/v7/finance/download/BHP.AX?period1=1609200000&period2=1609286400&interval=1d&events=history&includeAdjustedClose=true"
Date,Open,High,Low,Close,Adj Close,Volume
2020-12-29,43.110001,43.200001,42.840000,42.919998,42.919998,2767552
2020-12-30,43.000000,43.130001,42.680000,42.980000,42.980000,1966902
*/

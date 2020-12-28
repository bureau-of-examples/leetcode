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

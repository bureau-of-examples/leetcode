package zhy2002.trading;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class Candle {
    String date;
    double open;
    double high;
    double low;
    double close;
    double volume;
}

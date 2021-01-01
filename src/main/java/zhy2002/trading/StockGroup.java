package zhy2002.trading;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class StockGroup {

    private final String name;
    private final List<String> symbols;

}

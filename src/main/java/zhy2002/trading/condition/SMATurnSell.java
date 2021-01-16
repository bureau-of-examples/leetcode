package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.trading.Trader;

public class SMATurnSell implements TradeCondition {

    public boolean isMet(Trader trader, Chart chart, int index) {
        return false;
    }
}

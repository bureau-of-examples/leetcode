package zhy2002.trading.condition;

import zhy2002.trading.Chart;
import zhy2002.trading.Trade;

public class SMATurnSell implements TradeCondition {

    @Override
    public boolean isMet(Trade trade, Chart chart, int index) {
        return false;
    }
}

package zhy2002.trading.condition;

import zhy2002.trading.Chart;

public interface TradeCondition {
    boolean isMet(Chart chart, int index);
}

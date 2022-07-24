package zhy2002.trading.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StrategyPair {
    Strategy buyStrategy;
    Strategy sellStrategy;
}

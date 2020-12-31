package zhy2002.trading.strategy;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import zhy2002.trading.condition.TradeCondition;

import java.util.Iterator;
import java.util.function.Function;

@AllArgsConstructor
public final class StrategyGeneratorV2 implements Iterable<Strategy> {

    private final String name;
    private final ParameterSourceIterator plg;
    private final Function<ParameterSource, TradeCondition> conditionFunc;

    @NotNull
    @Override
    public Iterator<Strategy> iterator() {
        return new StrategyIterator();
    }

    private class StrategyIterator implements Iterator<Strategy> {

        @Override
        public boolean hasNext() {
            return plg.hasNext();
        }

        @Override
        public Strategy next() {
            var pl = plg.next();
            var condition = conditionFunc.apply(pl);
            return new Strategy(name + pl.toString(), condition);
        }
    }
}

package zhy2002.trading.strategy;

import com.google.common.base.Preconditions;

import java.lang.reflect.Array;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ParameterCrossProduct extends ParameterSourceIterator {

    private final LinkedHashMap<String, Object> parameterValues = new LinkedHashMap<>();
    private final Map<String, Integer> nextIndexMap = new TreeMap<>();
    private boolean done;

    @Override
    public boolean hasNext() {
        return !done;
    }

    @Override
    public ParameterSource next() {
        for (var name : parameterNames()) {
            setParameterValue(name, Array.get(parameterValues.get(name), nextIndexMap.get(name)));
        }
        // move to next
        for (var name : parameterNames()) {
            var array = parameterValues.get(name);
            var index = nextIndexMap.get(name);
            if (index + 1 < Array.getLength(array)) {
                nextIndexMap.put(name, index + 1);
                return this;
            } else {
                nextIndexMap.put(name, 0);
            }
        }
        done = true;
        return this;
    }

    @Override
    public void reset() {
        done = false;
    }

    public ParameterCrossProduct withParameter(String name, Object valueArray) {
        Preconditions.checkArgument(valueArray.getClass().isArray()); //use array to force type declaration

        parameterValues.put(name, valueArray);
        nextIndexMap.put(name, 0);
        return this;
    }

    @Override
    protected Iterable<String> parameterNames() {
        return parameterValues.keySet();
    }
}

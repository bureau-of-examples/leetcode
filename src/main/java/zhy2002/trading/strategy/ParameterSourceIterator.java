package zhy2002.trading.strategy;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public abstract class ParameterSourceIterator implements Iterator<ParameterSource>, ParameterSource {

    private final Map<String, Object> valueMap = new TreeMap<>();

    protected void setParameterValue(String name, Object value) {
        valueMap.put(name, value);
    }

    @Override
    public Integer getInt(String name) {
        return (Integer) valueMap.get(name);
    }

    @Override
    public Double getDouble(String name) {
        return (Double) valueMap.get(name);
    }

    protected abstract Iterable<String> parameterNames();

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String name : parameterNames()) {
            Object value = valueMap.get(name);
            if (result.length() == 0) {
                result.append("(");
            } else {
                result.append(",");
            }
            result.append(value);
        }
        if (result.length() > 0) {
            result.append(")");
        }
        return result.toString();
    }
}

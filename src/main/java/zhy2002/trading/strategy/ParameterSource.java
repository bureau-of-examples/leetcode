package zhy2002.trading.strategy;

public interface ParameterSource {

    Integer getInt(String name);

    Double getDouble(String name);
}

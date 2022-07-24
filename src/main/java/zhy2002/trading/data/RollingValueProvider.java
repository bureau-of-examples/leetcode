package zhy2002.trading.data;

import com.google.common.base.Preconditions;
import lombok.Getter;

/**
 * Rolling value computation that summarise {@code window} underlying values into a single value.
 */
public abstract class RollingValueProvider implements ValueProvider {

    @Getter
    private final int startIndex;
    @Getter
    private final int window;
    private final double[] values;


    public RollingValueProvider(int dataStartIndex, int window, double[] values) {
        this.startIndex = startIndex(dataStartIndex, window);
        this.window = window;
        this.values = values;
    }

    protected static int startIndex(int dataStartIndex, int window) {
        return dataStartIndex + (window - 1);
    }

    @Override
    public double get(int i) {
        Preconditions.checkArgument(i >= getStartIndex());
        return values[i - getStartIndex()];
    }

    @Override
    public int length() {
        return values.length + getStartIndex();
    }

}

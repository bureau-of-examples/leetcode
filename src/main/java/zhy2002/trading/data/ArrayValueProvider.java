package zhy2002.trading.data;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ArrayValueProvider implements ValueProvider {

    private final double[] array;

    @Override
    public double get(int i) {
        return array[i];
    }

    @Override
    public int length() {
        return array.length;
    }
}

package zhy2002.trading.data;

import java.util.ArrayDeque;

public class RollingMaxProvider extends RollingValueProvider {

    public RollingMaxProvider(ValueProvider data, int window) {
        super(data.getStartIndex(), window, compute(data, window));
    }

    private static double[] compute(ValueProvider data, int window) {
        var startIndex = startIndex(data.getStartIndex(), window);
        var values = new double[data.length() - startIndex];

        var maxDeque = new ArrayDeque<Double>();//big to small
        for (int i = data.getStartIndex(); i < data.length(); i++) {
            var v = data.get(i);
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < v) {
                maxDeque.pollLast();
            }
            maxDeque.add(v);

            if (i >= startIndex) {
                values[i - startIndex] = maxDeque.getFirst();

                var oldV = data.get(i - (window - 1));
                if (oldV == maxDeque.getFirst()) {
                    maxDeque.pollFirst();
                }
            }
        }
        return values;
    }
}

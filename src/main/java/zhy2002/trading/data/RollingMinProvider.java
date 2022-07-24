package zhy2002.trading.data;


import java.util.ArrayDeque;

public class RollingMinProvider extends RollingValueProvider {

    public RollingMinProvider(ValueProvider data, int window) {
        super(data.getStartIndex(), window, compute(data, window));
    }

    private static double[] compute(ValueProvider data, int window) {
        var startIndex = startIndex(data.getStartIndex(), window);
        var values = new double[data.length() - startIndex];

        var minDeque = new ArrayDeque<Double>();//small to big
        for (int i = data.getStartIndex(); i < data.length(); i++) {
            var v = data.get(i);
            while (!minDeque.isEmpty() && minDeque.peekLast() > v) {
                minDeque.pollLast();
            }
            minDeque.add(v);

            if (i >= startIndex) {
                values[i - startIndex] = minDeque.getFirst();

                var oldV = data.get(i - (window - 1));
                if (oldV == minDeque.getFirst()) {
                    minDeque.pollFirst();
                }
            }
        }
        return values;
    }
}

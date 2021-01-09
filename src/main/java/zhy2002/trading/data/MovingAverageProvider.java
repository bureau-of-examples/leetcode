package zhy2002.trading.data;

public class MovingAverageProvider extends RollingValueProvider {

    public MovingAverageProvider(ValueProvider data, int window) {
        super(data.getStartIndex(), window, compute(data, window));
    }

    private static double[] compute(ValueProvider data, int window) {
        var startIndex = startIndex(data.getStartIndex(), window);
        var values = new double[data.length() - startIndex];
        double total = 0;
        for (int i = data.getStartIndex(); i < data.length(); i++) {
            total += data.get(i);
            if (i >= startIndex) {
                values[i - startIndex] = total / window;
                total -= data.get(i - (window - 1));
            }
        }
        return values;
    }
}

package zhy2002.trading.data;

public class NormalizedSlopeProvider extends RollingValueProvider {

    public NormalizedSlopeProvider(ValueProvider data, int window) {
        super(data.getStartIndex(), window, compute(data, window));
    }

    public static double[] compute(ValueProvider data, int window) {
        var startIndex = startIndex(data.getStartIndex(), window);
        var values = new double[data.length() - startIndex];
        final double w = window;
        double total = 0;
        for (int i = data.getStartIndex(); i < data.length(); i++) {
            total += data.get(i);
            if (i >= startIndex) {
                int j = i - (window - 1);
                double sumX = (i - j) * w / 2;
                double sumX2 = w * i * i - w * w * i + i * w + w * w * w / 3 - w * w / 2 + w / 6;
                double sumY = 0, sumXY = 0;
                for (int x = j; x <= i; x++) {
                    double y = data.get(x) / data.get(j);
                    sumY += y;
                    sumXY += x * y;
                }
                values[i - startIndex] = (w * sumXY - sumX * sumY) / (w * sumX2 - sumX * sumX);
            }
        }
        return values;
    }
}

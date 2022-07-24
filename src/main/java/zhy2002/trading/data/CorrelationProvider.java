package zhy2002.trading.data;

public class CorrelationProvider extends RollingValueProvider {

    public CorrelationProvider(ValueProvider data, int window) {
        super(data.getStartIndex(), window, compute(data, window));
    }

    public static double[] compute(ValueProvider data, int window) {
        var startIndex = startIndex(data.getStartIndex(), window);
        var values = new double[data.length() - startIndex];
        double total = 0;
        for (int i = data.getStartIndex(); i < data.length(); i++) {
            total += data.get(i);
            if (i >= startIndex) {
                int j = i - (window - 1);
                double meanY = total / window;
                double meanX = (i + j) * (double) window / 2 / window;
                double sumDxDy = 0;
                double sumDx2 = 0;
                double sumDy2 = 0;
                for (int x = j; x <= i; x++) {
                    double dX = x - meanX;
                    double dY = data.get(x) - meanY;
                    sumDx2 += dX * dX;
                    sumDy2 += dY * dY;
                    sumDxDy += dX * dY;
                }
                values[i - startIndex] = sumDxDy / (Math.sqrt(sumDx2) * Math.sqrt(sumDy2));
                total -= data.get(j);
            }
        }
        return values;
    }
}

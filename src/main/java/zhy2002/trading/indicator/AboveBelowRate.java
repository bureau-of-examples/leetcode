package zhy2002.trading.indicator;

import zhy2002.trading.data.ValueProvider;

/**
 * Count in the given window, what percentage of data1 values are above/below the corresponding data2 values.
 */
public class AboveBelowRate {
    private final int startIndex;
    private final int window;
    private final int[] aboveCounts;
    private final int[] belowCounts;

    public AboveBelowRate(ValueProvider data1, ValueProvider data2, int window) {
        assert data1.length() == data2.length();
        this.window = window;
        this.startIndex = Math.max(data1.getStartIndex(), data2.getStartIndex()) + (window - 1);
        int aboveCount = 0, belowCount = 0;
        aboveCounts = new int[data1.length() - startIndex];
        belowCounts = new int[data1.length() - startIndex];
        for (int i = startIndex - (window - 1); i < data1.length(); i++) {
            if (data1.get(i) > data2.get(i)) {
                aboveCount++;
            } else if (data1.get(i) < data2.get(i)) {
                belowCount++;
            }
            if (i >= startIndex) {
                aboveCounts[i - startIndex] = aboveCount;
                belowCounts[i - startIndex] = belowCount;
                var oldIndex = i - (window - 1);
                if (data1.get(oldIndex) > data2.get(oldIndex)) {
                    aboveCount--;
                } else if (data1.get(oldIndex) < data2.get(oldIndex)) {
                    belowCount--;
                }
            }
        }
    }

    public double getAboveRate(int i) {
        return aboveCounts[i - startIndex] / (double) window;
    }

    public double getBelowRate(int i) {
        return belowCounts[i - startIndex] / (double) window;
    }

}

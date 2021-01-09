package zhy2002.trading.data;

/**
 * An interface used to read an array of double values.
 */
public interface ValueProvider {

    /**
     * Get value at index i. Note the first a few indices might not be accessible (e.g. SMA).
     */
    double get(int i);

    default int getStartIndex() {
        return 0;
    }

    /**
     * Get the total length of the array.
     */
    int length();

}

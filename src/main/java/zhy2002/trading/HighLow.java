package zhy2002.trading;

import lombok.Getter;
import zhy2002.trading.data.ValueProvider;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Find highs and lows in a chart
 */
public class HighLow {

    private final ValueProvider data;
    /**
     * collected highs must be highest in {@code window} days to the left and to the right.
     */
    private final int window;
    @Getter
    private final List<Integer> highIndices = new ArrayList<>();
    @Getter
    private final List<Integer> lowIndices = new ArrayList<>();

    public HighLow(ValueProvider data, int window) {
        this.data = data;
        this.window = window;
        Deque<Double> windowHighs = new ArrayDeque<>();
        Deque<Double> windowLows = new ArrayDeque<>();
        for (int i = data.getStartIndex(); i < data.length(); i++) {
            processValue(highIndices, windowHighs, i, true);
            processValue(lowIndices, windowLows, i, false);
        }
    }

    private void processValue(List<Integer> indices, Deque<Double> deque, int i, boolean isDequeDesc) {
        // add to desc stack
        var v = data.get(i);
        while (!deque.isEmpty() && (isDequeDesc ? deque.peekLast() < v : deque.peekLast() > v)) {
            deque.pollLast();
        }
        deque.add(v);

        if (deque.getFirst() == v) { // this is max in window
            if (!indices.isEmpty() && indices.get(indices.size() - 1) > i - window) {
                indices.set(indices.size() - 1, i);
            } else {
                indices.add(i);
            }
        }

        // remove out of window value from desc stack
        if (i - (window - 1) >= data.getStartIndex()) {
            var oldV = data.get(i - (window - 1));
            if (oldV == deque.getFirst()) {
                deque.pollFirst();
            }
        }
    }
}

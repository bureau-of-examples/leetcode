package zhy2002.leetcode.solutions.waterandjugproblem;

import java.util.*;

/**
 *
 * This will result in tle.
 */
public class BFSSolution implements Solution{

    private static class State {
        private int x;
        private int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isTerminal(int z) {
            return x == z || y == z || x + y == z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return x == state.x &&
                    y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean canMeasureWater(int x, int y, int z) {
        Set<State> examinedStates = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        int xCapacity = x, yCapacity = y;
        queue.add(new State(0, 0));
        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (examinedStates.contains(current)) {
                continue;
            }
            if (current.isTerminal(z))
                return true;
            if (current.x != xCapacity) {
                queue.add(new State(xCapacity, current.y));
                if (current.y != 0) {
                    int delta = Math.min(current.y, xCapacity - current.x);
                    queue.add(new State(current.x + delta, current.y - delta));
                }
            }
            if (current.y != yCapacity) {
                queue.add(new State(current.x, yCapacity));
                if (current.x != 0) {
                    int delta = Math.min(current.x, yCapacity - current.y);
                    queue.add(new State(current.x - delta, current.y + delta));
                }
            }
            if (current.x != 0) {
                queue.add(new State(0, current.y));
            }
            if (current.y != 0) {
                queue.add(new State(current.x, 0));
            }
            examinedStates.add(current);
        }
        return false;
    }
}

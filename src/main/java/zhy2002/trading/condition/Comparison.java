package zhy2002.trading.condition;

public enum Comparison {
    HIGHER {
        @Override
        public boolean isTrue(double val1, double val2) {
            return val1 > val2;
        }
    },
    LOWER {
        @Override
        public boolean isTrue(double val1, double val2) {
            return val1 < val2;
        }
    };

    public abstract boolean isTrue(double val1, double val2);
}

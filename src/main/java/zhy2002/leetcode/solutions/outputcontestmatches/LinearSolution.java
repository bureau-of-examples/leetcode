package zhy2002.leetcode.solutions.outputcontestmatches;

public class LinearSolution {

    private StringBuilder sb;
    private int n;

    public String findContestMatch(int n) {
        sb = new StringBuilder();
        this.n = n;
        solve(0,  1,n/2);
        return sb.toString();
    }

    private void solve(int leftIndex, int leftValue, int size) {
        sb.append("(");
        if (size == 1) {
            sb.append(leftValue);
        } else {
            solve(leftIndex, leftValue, size / 2);
        }
        sb.append(",");
        int rightValue = n / size + 1 - leftValue;
        if (size == 1) {
            sb.append(rightValue);
        } else {
            solve(leftIndex + size, rightValue, size / 2);
        }
        sb.append(")");
    }
}

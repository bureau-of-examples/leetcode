package zhy2002.leetcode.solutions.waterandjugproblem;

/**
 * z <= x + y is measurable <=> z is a multiple of gcd(x, y).
 * Mathematically induction that
 * if x, y can only directly measure k*gcd(x, y), then after a legal move
 * x' and y' can only directly measure k'*gcd(x,y)
 */
public class MathSolution implements Solution {

    @Override
    public boolean canMeasureWater(int x, int y, int z) {
        if(x == 0 && y == 0)
            return z == 0;
        if(z > x + y)
            return false;
        return z % gcd(x, y) ==  0;
    }

    private int gcd(int x, int y) {
        int a = Math.max(x, y);
        int b = Math.min(x, y);

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}

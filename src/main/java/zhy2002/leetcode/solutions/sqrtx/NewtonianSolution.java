package zhy2002.leetcode.solutions.sqrtx;

/**
 * Newton's method.
 */
public class NewtonianSolution implements Solution{

    public int sqrt(int x) {//solve t in t^2=x with Newton's method
        if (x == 0)
            return 0;
        float t0 = 23170f;
        while (true) {
            float t1 = (t0 + x / t0) * 0.5f;//t0 - (t0*t0-x)/(2*t0);
            if (Math.abs(t1 - t0) < 0.0000005f) {
                int result = (int) t1;
                if (result * result > x)
                    return result - 1;
                return result;
            }
            t0 = t1;
        }
    }
}

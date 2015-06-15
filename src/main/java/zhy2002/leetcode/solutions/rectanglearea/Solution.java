package zhy2002.leetcode.solutions.rectanglearea;

/**
 * https://leetcode.com/problems/rectangle-area/
 */
public class Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long w1 = C - A;
        int h1 = D - B;
        long w2 = G - E;
        int h2 = H - F;
        long total = w1 * h1 + w2 * h2;
        int iw = overlap(A, C, E, G);
        int ih = overlap(B, D, F, H);
        int intersection = iw * ih;
        return (int)(total - intersection);
    }

    private int overlap(int left1, int right1, int left2, int right2) {
        return Integer.max(0, Integer.min(right1, right2) - Integer.max(left1, left2));
    }
}

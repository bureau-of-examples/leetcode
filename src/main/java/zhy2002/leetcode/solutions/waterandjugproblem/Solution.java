package zhy2002.leetcode.solutions.waterandjugproblem;

/**
 * https://leetcode.com/problems/water-and-jug-problem/
 * <p>
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 * <p>
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 * <p>
 * Operations allowed:
 * <p>
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 * <p>
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * Example 2:
 * <p>
 * Input: x = 2, y = 6, z = 5
 * Output: False
 */
public interface Solution {

    boolean canMeasureWater(int x, int y, int z);

}

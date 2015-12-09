package zhy2002.leetcode.solutions.flatten2dvector;

import java.util.List;

/**
 * https://leetcode.com/problems/flatten-2d-vector/
 * Implement an iterator to flatten a 2d vector.
 *
 * For example,
 * Given 2d vector =
 *
 * [
 * [1,2],
 * [3],
 * [4,5,6]
 * ]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */
public class Vector2D {

    private List<List<Integer>> vec2d;
    private int listIndex = 0;
    private int itemIndex = -1;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
    }

    public int next() {
        itemIndex++;
        while (itemIndex >= vec2d.get(listIndex).size()){
            listIndex++;
            itemIndex = 0;
        }
        return vec2d.get(listIndex).get(itemIndex);
    }

    public boolean hasNext() {
        int nextItemIndex = itemIndex + 1;
        for (int i = listIndex; i < vec2d.size(); i++) {
            List<Integer> list = vec2d.get(i);
            if(list.size() > nextItemIndex)
                return true;
            nextItemIndex = 0;
        }
        return false;
    }
}

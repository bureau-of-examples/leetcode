package zhy2002.leetcode.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode data structure.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

package zhy2002.leetcode.common;

/**
 * Leetcode data structure.
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left, right, next;
    public TreeLinkNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

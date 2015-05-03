package zhy2002.leetcode.solutions.clonegraph;

import zhy2002.leetcode.common.UndirectedGraphNode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/clone-graph/
 * Use a hash map to establish a mapping from old nodes to cloned nodes.
 * For each edge, create an edge between the cloned nodes.
 */
public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        createMapping(map, node);
        for (UndirectedGraphNode oldNode : map.keySet()) {
            UndirectedGraphNode newNode = map.get(oldNode);
            for (UndirectedGraphNode neighbor : oldNode.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    private static void createMapping(HashMap<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {
        if (node == null)
            return;

        if (!map.containsKey(node)) {
            map.put(node, new UndirectedGraphNode(node.label));
            for (UndirectedGraphNode neighbor : node.neighbors) {
                createMapping(map, neighbor);
            }
        }
    }

}

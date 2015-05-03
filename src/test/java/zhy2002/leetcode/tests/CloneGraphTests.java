package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.clonegraph.Solution;
import org.junit.Test;
import static org.junit.Assert.*;
import zhy2002.leetcode.common.UndirectedGraphNode;

public class CloneGraphTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        UndirectedGraphNode node = new UndirectedGraphNode(1);
        node.neighbors.add(node);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node.neighbors.add(node2);
        node2.neighbors.add(node);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node);
        node.neighbors.add(node3);
        UndirectedGraphNode rNode = solution.cloneGraph(node);
        assertEquals(1, rNode.label);
        UndirectedGraphNode rNode2 =  rNode.neighbors.get(1);
        UndirectedGraphNode rNode3 =  rNode.neighbors.get(2);
        assertEquals(2, rNode2.label);
        assertEquals(3, rNode3.label);

        assertTrue(rNode2.neighbors.contains(rNode));
        assertTrue(rNode2.neighbors.contains(rNode3));

    }
}

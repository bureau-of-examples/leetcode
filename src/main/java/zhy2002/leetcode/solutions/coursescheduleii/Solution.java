package zhy2002.leetcode.solutions.coursescheduleii;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class Solution {

    private static class GraphNode{

        public final int id;
        public final List<GraphNode> nodes = new ArrayList<>();

        public GraphNode(int id){
            this.id = id;
        }
    }

    private static class MyException extends RuntimeException{
    }

    public int[] findOrder(int numCourses, int[][] prerequisites){

        //build graph
        GraphNode[] nodes = new GraphNode[numCourses];
        for(int i=0; i<numCourses; i++){
            nodes[i] = new GraphNode(i);
        }
        for(int[] pair : prerequisites){
            nodes[pair[0]].nodes.add(nodes[pair[1]]);
        }

        //dfs
        int[] result = new int[numCourses];
        int populated = 0;
        for(int i=0; i<nodes.length; i++){
            if(nodes[i] != null) {
                try {
                    populated = putNode(result, populated, nodes, nodes[i], new GraphNode(-1));
                }catch (MyException ex){
                    return new int[0];
                }
            }
        }
        return result;
    }

    private int putNode(int[] result, int nextIndex, GraphNode[] nodes, GraphNode node, GraphNode dummy) {
        if(nodes[node.id] == dummy){ //on stack
            throw new MyException();
        }
        nodes[node.id] = dummy;

        for(GraphNode n : node.nodes) {
            if(nodes[n.id] != null){
                int oldNextIndex = nextIndex;
                nextIndex = putNode(result, nextIndex, nodes, n, dummy);
                if(oldNextIndex == nextIndex)
                    return oldNextIndex;
            }
        }

        result[nextIndex++] = node.id;
        nodes[node.id] = null;
        return nextIndex;
    }
}

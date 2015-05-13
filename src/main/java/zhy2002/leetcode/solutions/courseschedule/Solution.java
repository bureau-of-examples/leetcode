package zhy2002.leetcode.solutions.courseschedule;

/**
 * https://leetcode.com/problems/course-schedule/
 * DFS solution.
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build adjacency matrix
        boolean[][] mat = new boolean[numCourses][numCourses];
        for(int[] edge : prerequisites){
            mat[edge[0]][edge[1]] = true;
        }

        //dfs
        int[] visitFlags = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!dfs(i, visitFlags, mat))
                return false;
        }
        return true;
    }

    private boolean dfs(int i, int[] visitFlags, boolean[][] mat) {
        if(visitFlags[i] == 2)  //visited
            return true;

        if(visitFlags[i] == 1)  //already in the stack of pre-requisites
            return false;

        visitFlags[i] = 1;      //find pre-requisites of all pre-requisites
        for(int j=0; j<visitFlags.length; j++){
            if(mat[i][j])
             if(!dfs(j, visitFlags, mat))
                 return false;
        }

        visitFlags[i] = 2;
        return true;
    }
}

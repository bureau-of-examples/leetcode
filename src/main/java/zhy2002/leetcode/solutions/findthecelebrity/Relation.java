package zhy2002.leetcode.solutions.findthecelebrity;

/**
 * Dummy base class for testing the solution.
 */
public class Relation {

    private boolean[][] relationMatrix;

    public void loadRelationMatrix(boolean[][] relationMatrix) {
        this.relationMatrix = relationMatrix;
    }

    protected boolean knows(int a, int b) {
        return relationMatrix[a][b];
    }

}

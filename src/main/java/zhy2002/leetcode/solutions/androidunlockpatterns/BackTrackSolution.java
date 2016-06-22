package zhy2002.leetcode.solutions.androidunlockpatterns;


public class BackTrackSolution implements Solution {

    private int m;
    private int n;

    @Override
    public int numberOfPatterns(int m, int n) {
        this.m = m;
        this.n = n;
        int sum = 0;
        sum += track(0, 0, new boolean[][]{{true, false, false}, {false, false, false}, {false, false, false}}, 1) * 4;
        sum += track(0, 1, new boolean[][]{{false, true, false}, {false, false, false}, {false, false, false}}, 1) * 4;
        sum += track(1, 1, new boolean[][]{{false, false, false}, {false, true, false}, {false, false, false}}, 1);
        return sum;
    }

    //This is a naive back tracking solution.
    //two possible improvements are - 1. use symmetry: 1, 3, 7, 9 are the same and 2, 4, 6, 8 are the same.
    //2. can the result for length i and number of ways for m,n is #ways m + #ways m + 1 + ...
    private int track(int startRow, int startCol, boolean[][] visited, int previousLength) {
        int sum = 0;
        if (m <= previousLength && previousLength <= n) {
            sum++;
        }
        if (previousLength < n) {
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (canMove(startRow, startCol, i, j, visited)) {
                        visited[i][j] = true;
                        sum += track(i, j, visited, previousLength + 1);
                        visited[i][j] = false;
                    }
                }
            }
        }

        return sum;
    }

    private boolean canMove(int fromRow, int fromCol, int toRow, int toCol, boolean[][] visited) {
        if (fromRow == toRow && fromCol == toCol || visited[toRow][toCol])
            return false;

        if (Math.abs(fromRow - toRow) <= 1 && Math.abs(fromCol - toCol) <= 1)
            return true;

        double midCol = (fromRow + toRow) / 2.0;
        double midRow = (fromCol + toCol) / 2.0;
        if (midCol == (int) midCol) {
            if (midRow == (int) midRow) {
                return visited[(int) midRow][(int) midCol];
            } else {
                return true;//return visited[(int) Math.floor(midRow)][1] && visited[(int) Math.ceil(midRow)][1];
            }
        } else {
            if (midRow == (int) midRow) {
                return true;//return visited[1][(int) Math.floor(midCol)] && visited[1][(int) Math.ceil(midCol)];
            } else {
                assert false : "Impossible";
                throw new RuntimeException("Impossible");
            }
        }
    }

}

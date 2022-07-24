package cs2022;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SolutionI {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] parts = br.readLine().split("\\s+");
            int r = Integer.parseInt(parts[0]);
            int c = Integer.parseInt(parts[1]);
            char[][] grid = new char[r][];
            for (int i = 0; i < grid.length; i++) {
                grid[i] = br.readLine().toCharArray();
            }
            System.out.println(solve(r, c, grid));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(int r, int c, char[][] grid) {
        int left = 1, right = 1;
        while (grid[1][right + 1] != '#') {
            right++;
        }
        int top = 1, bottom = 1;
        while (grid[bottom + 1][1] != '#') {
            bottom++;
        }

        Set<String> signatures = new HashSet<>();
        int count = 0;
        for (int i = top; i < r; i += (bottom - top + 1) + 1) {
            for (int j = left; j < c; j += (right - left + 1) + 1) {
                if (addSignatures(signatures, grid, i, j, i + (bottom - top), j + (right - left))) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean addSignatures(Set<String> signatures, char[][] grid, int top, int left, int bottom, int right) {
        if (signatures.add(genString1(grid, left, right, top, bottom))) {
            signatures.add(genString2(grid, left, right, top, bottom));
            signatures.add(genString3(grid, left, right, top, bottom));
            signatures.add(genString4(grid, left, right, top, bottom));
            return true;
        }
        return false;
    }

    private static String genString1(char[][] grid, int left, int right, int top, int bottom) {
        StringBuilder sb = new StringBuilder();
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String genString2(char[][] grid, int left, int right, int top, int bottom) {
        StringBuilder sb = new StringBuilder();
        for (int j = right; j >= left; j--) {
            for (int i = top; i <= bottom; i++) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String genString3(char[][] grid, int left, int right, int top, int bottom) {
        StringBuilder sb = new StringBuilder();
        for (int i = bottom; i >= top; i--) {
            for (int j = right; j >= left; j--) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String genString4(char[][] grid, int left, int right, int top, int bottom) {
        StringBuilder sb = new StringBuilder();
        for (int j = left; j <= right; j++) {
            for (int i = bottom; i >= top; i--) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

package cs2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class SolutionH {

    private static class DirDetails {
        public int size;
        public char symbol = ' ';
        public Map<String, DirDetails> children = new LinkedHashMap<>();
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());
            String[] lines = new String[count];
            for (int i = 0; i < count; i++) {
                lines[i] = br.readLine();
            }
            solve(lines, Integer.parseInt(br.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(String[] lines, int t) {
        DirDetails root = new DirDetails();
        for (String line : lines) {
            insert(root, line, t);
        }

        StringBuilder sb = new StringBuilder(lines.length * 100);
        printTree(sb, root, "/", t);
        System.out.print(sb.toString());
    }

    // pre order
    private static void printTree(StringBuilder sb, DirDetails node, String path /*path of node*/, int t) {
        // print node
        sb.append(String.format("%s %s %d%n", node.symbol, path, node.size));
        if (node.symbol != '-') {
            return; // no need to expand
        }

        // print children
        List<String> subDirNames = new ArrayList<>(node.children.keySet());
        Collections.sort(subDirNames);
        for (var subDirName : subDirNames) {
            printTree(sb, node.children.get(subDirName), String.format("%s%s/", path, subDirName), t);
        }
    }

    // create dir and size.
    private static void insert(DirDetails dir, String line, int t) {
        int fileSize = Integer.parseInt(line.substring(line.lastIndexOf(' ') + 1));
        dir.size += fileSize;
        int startIndex = 1, endIndex;
        while ((endIndex = line.indexOf('/', startIndex + 1)) >= 0) {
            String name = line.substring(startIndex, endIndex);
            var subDir = dir.children.get(name);
            if (subDir == null) {
                subDir = new DirDetails();
                dir.children.put(name, subDir);
                if (dir.symbol == ' ') {
                    dir.symbol = '+';
                }
            }
            subDir.size += fileSize;
            if (subDir.size >= t) {
                dir.symbol = '-';
            }
            dir = subDir;
            startIndex = endIndex + 1;
        }
    }
}

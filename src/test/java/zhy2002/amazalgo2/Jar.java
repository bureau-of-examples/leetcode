package zhy2002.amazalgo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Jar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Map<Integer, List<Integer>> children = new HashMap<>();
        for (int i=1; i<=n; i++) {
            children.put(i, new ArrayList<>());
        }

        for (int i = 2; i<=n; i++) {
            int parent = scanner.nextInt();
            children.get(parent).add(i);
        }

//        Map<Integer, List<Integer>> children = new HashMap<>();
//        children.put(1, new ArrayList<>());
//        children.put(2, new ArrayList<>());
//        children.put(3, new ArrayList<>());
//        children.put(4, new ArrayList<>());
//        children.put(5, new ArrayList<>());
//        children.get(1).add(2);
//        children.get(1).add(3);
//        children.get(2).add(4);
//        children.get(4).add(5);

        long[] result = solve(children, 1);
        System.out.println(result[0]);
    }


    private static long[] solve(Map<Integer, List<Integer>> children, int root) {
        long[] result = new long[] {0, 1};

        List<Integer> list = children.get(root);
        for (Integer child : list) {
            long[] r = solve(children, child);
            result[0] += r[0] + r[1];
            result[1] += r[1];
        }

        return result;
    }
}

package cs2022;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SolutionF {

    private static class Group {
        public String type;
        public String hand;
        public int count;

        public Group(String line) {
            String[] parts = line.split("\\s+");
            this.type = parts[0];
            this.hand = parts[1];
            this.count = Integer.parseInt(parts[2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Group[] groups = new Group[n];
        int total = 0;
        for (int i = 0; i < groups.length; i++) {
            groups[i] = new Group(scanner.nextLine());
            total += groups[i].count;
        }
        int take = solve(groups);
        if (take < total) {
            System.out.println(take + 1);
        } else {
            System.out.println("impossible");
        }
    }

    private static int solve(Group[] groups) {
        Map<String, int[]> typeMap = new HashMap<>();
        for (Group g : groups) {
            int[] counts = typeMap.computeIfAbsent(g.type, k -> new int[3]);
            if (g.hand.equals("left")) {
                counts[0] += g.count;
            } else if (g.hand.equals("right")) {
                counts[1] += g.count;
            } else {
                counts[2] = g.count;
            }
        }

        int take = 0;
        for (int[] counts : typeMap.values()) {
            int t = Math.max(counts[0], counts[1]);
            if (t == 0 && counts[2] > 0) {
                t = 1;
            }
            take += t;
        }
        return take;
    }


}

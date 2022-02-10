package cs2022.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SolutionG {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCount = Integer.parseInt(br.readLine());
            int[] coolDownList = new int[testCount];
            char[][] tasksList = new char[testCount][];
            for (int i = 0; i < testCount; i++) {
                tasksList[i] = br.readLine().toCharArray();
                coolDownList[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < testCount; i++) {
                System.out.println(solve(tasksList[i], coolDownList[i]));
            }
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }
    }

    private static int solve(char[] tasks, int coolDown) {
        Map<Integer, Integer> taskCount = new HashMap<>();
        for (char ch : tasks) {
            taskCount.put((int) ch - 'A', taskCount.getOrDefault((int) ch - 'A', 0) + 1);
        }
        int time = 0;
        boolean[] disallowedList = new boolean[26];
        Deque<int[]> exitQueue = new ArrayDeque<>();
        //greedy
        while (!taskCount.isEmpty()) {
            Map.Entry<Integer, Integer> nextTaskEntry = null;
            for (Map.Entry<Integer, Integer> entry : taskCount.entrySet()) {
                if (!disallowedList[entry.getKey()] && (nextTaskEntry == null || nextTaskEntry.getValue() < entry.getValue())) {
                    nextTaskEntry = entry;
                }
            }
            if (nextTaskEntry == null) {
                assert !exitQueue.isEmpty();
                int[] item = exitQueue.poll();
                time = item[1]; // forward to exit time.
                disallowedList[item[0]] = false;
            } else {
                time++;
                int remainingCount = nextTaskEntry.getValue() - 1;
                if (remainingCount == 0) {
                    taskCount.remove(nextTaskEntry.getKey());
                } else {
                    taskCount.put(nextTaskEntry.getKey(), remainingCount);
                    disallowedList[nextTaskEntry.getKey()] = true;
                    exitQueue.add(new int[]{nextTaskEntry.getKey(), time + coolDown});
                }
            }
            while (!exitQueue.isEmpty() && exitQueue.peek()[1] <= time) {
                disallowedList[exitQueue.poll()[0]] = false;
            }
        }
        return time;
    }

}

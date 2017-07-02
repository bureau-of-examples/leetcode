package zhy2002.leetcode;

import zhy2002.leetcode.common.Interval;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.common.TreeNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Tests util class.
 */
public final class Utils {
    private Utils() {
    }

    private static final Random RANDOM = new Random(99);

    static {

    }

    public static Random random() {
        return RANDOM;
    }

    public static long factorial(byte n) {
        long result = 1;
        for (long i = 2; i <= n; i++) {
            result *= i; //we dont care about overflow as this is testing code
        }
        return result;
    }

    public static <T> List<List<T>> arrayOfArrayToListOfList(T[][] array) {
        if (array == null)
            return null;

        ArrayList<List<T>> result = new ArrayList<>();
        for (T[] item : array) {
            result.add(Arrays.asList(item));
        }
        return result;

    }

    public static ListNode createLinkedList(int... items) {
        ListNode head = null;
        ListNode current = null;
        for (int i : items) {
            if (head == null) {
                head = current = new ListNode(i);
            } else {
                current.next = new ListNode(i);
                current = current.next;
            }
        }
        return head;
    }

    public static int[] intArrayFromString(String src) {
        if (src.trim().length() == 0)
            return new int[0];

        String[] integers = src.split("\\s+");
        int[] result = new int[integers.length];
        for (int i = 0; i < integers.length; i++) {
            result[i] = Integer.parseInt(integers[i]);
        }
        return result;
    }

    public static int[] randomIntArray(int size, int min, int maxExclusive) {
        Random random = random();
        int diff = maxExclusive - min;
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = min + random.nextInt(diff);
        }
        return result;
    }

    public static int[] createRange(int start, int end/*exclusive*/) {
        int[] result = new int[end - start];
        for (int i = start; i < end; i++) {
            result[i - start] = i;
        }
        return result;
    }

    public static String intervalsToString(Iterable<Interval> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null) {
            stringBuilder.append("[");
            boolean first = true;
            for (Interval interval : list) {
                if (first)
                    first = false;
                else
                    stringBuilder.append(",");

                stringBuilder.append("[");
                if (interval != null) {
                    stringBuilder.append(interval.start);
                    stringBuilder.append(",");
                    stringBuilder.append(interval.end);
                }
                stringBuilder.append("]");
            }
            stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }

    public static List<Interval> stringToIntervals(String str) {

        List<Interval> result = new ArrayList<>();
        if (str.length() <= 4)
            return result;
        str = str.substring(2, str.length() - 2);
        String[] intervals = str.split("\\]\\s*,\\s*\\[");
        for (String pair : intervals) {
            int index = pair.indexOf(',');
            result.add(new Interval(Integer.parseInt(pair.substring(0, index)), Integer.parseInt(pair.substring(index + 1))));
        }
        return result;
    }

    public static Interval[] stringToIntervalArray(String str) {
        List<Interval> list = stringToIntervals(str);
        Interval[] array = new Interval[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static String integersToString(Iterable<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        if (list != null) {
            boolean first = true;
            for (Integer i : list) {
                if (first)
                    first = false;
                else
                    stringBuilder.append(",");

                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }

    public static char[][] stringToCharMatrix(String src) {
        if (src == null)
            return null;

        String[] lines = src.split(" ");
        char[][] result = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            result[i] = lines[i].toCharArray();
        }
        return result;
    }

    public static String listToString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (String str : list) {
            if (first)
                first = false;
            else
                stringBuilder.append(" ");
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static String charMatrixToString(char[][] matrix) {
        if (matrix == null)
            return null;

        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;

        for (char[] row : matrix) {
            if (first)
                first = false;
            else
                stringBuilder.append(" ");
            stringBuilder.append(row);
        }
        return stringBuilder.toString();
    }

    public static String intMatrixToString(int[][] matrix) {
        if (matrix == null)
            return null;

        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;

        for (int[] row : matrix) {
            if (first)
                first = false;
            else
                stringBuilder.append(" ");

            intArrayToString(stringBuilder, row);
        }
        return stringBuilder.toString();
    }

    private static void intArrayToString(StringBuilder stringBuilder, int[] row) {
        boolean first = true;
        for (int val : row) {
            if (first)
                first = false;
            else
                stringBuilder.append(',');
            stringBuilder.append(val);
        }
    }

    public static int[][] stringToIntMatrix(String src) {
        if (src == null)
            return null;

        if (src.length() == 0)
            return new int[0][];

        String[] lines = src.split(",");
        int[][] result = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            String[] items = lines[i].split("\\s+");
            result[i] = new int[items.length];
            for (int j = 0; j < items.length; j++) {
                result[i][j] = Integer.parseInt(items[j]);
            }
        }
        return result;
    }

    public static String listOfIntArrayToString(List<int[]> list) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (int[] item : list) {
            if (first)
                first = false;
            else
                stringBuilder.append(" ");

            stringBuilder.append("[");

            for (int i = 0; i < item.length; i++) {
                if (i > 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(item[i]);
            }

            stringBuilder.append("]");

        }
        return stringBuilder.toString();
    }

    public static String listOfListToString(List<? extends List<?>> list) {
        if (list == null)
            return null;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        boolean first = true;
        for (List<?> item : list) {
            if (first)
                first = false;
            else
                stringBuilder.append(",");

            boolean firstCell = true;
            stringBuilder.append("[");
            for (Object cell : item) {
                if (firstCell)
                    firstCell = false;
                else
                    stringBuilder.append(",");

                stringBuilder.append(cell);
            }
            stringBuilder.append("]");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String linkedListToString(ListNode result) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        while (result != null) {
            if (first)
                first = false;
            else
                stringBuilder.append(" ");
            stringBuilder.append(result.val);
            result = result.next;
        }
        return stringBuilder.toString();
    }

    public static int[][] randIntMatrix(int width, int height) {
        int[][] result = new int[height][width];
        Random rand = random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = rand.nextInt(32);
            }
        }
        return result;
    }

    public static String binaryTreeToString(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int notNullCount = 1;
        do {
            TreeNode node = queue.poll();
            if (node != null) {
                stringBuilder.append(" ");
                stringBuilder.append(node.val);
                notNullCount--;
                queue.add(node.left);
                if (node.left != null)
                    notNullCount++;
                queue.add(node.right);
                if (node.right != null)
                    notNullCount++;
            } else {
                stringBuilder.append(" #");
            }
        } while (notNullCount != 0);

        return stringBuilder.substring(1);
    }

    public static TreeNode stringToBinaryTree(String s) {
        String[] values = s.split(",");
        int index = 0;
        TreeNode root = buildNode(values, index++);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = buildNode(values, index++);
            if (node.left != null) {
                queue.add(node.left);
            }
            node.right = buildNode(values, index++);
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    private static TreeNode buildNode(String[] values, int index) {
        if (index >= values.length)
            return null;

        if ("null".equals(values[index]))
            return null;

        int val = Integer.parseInt(values[index]);
        return new TreeNode(val);
    }

    public static int[] intArrayFromResource(Class<?> testClazz, String resourceSuffix) {

        try (InputStream stream = testClazz.getResourceAsStream(testClazz.getSimpleName() + resourceSuffix)) {
            ArrayList<Integer> input = new ArrayList<>();
            Scanner scanner = new Scanner(stream);
            scanner.useDelimiter(",");
            while (scanner.hasNextInt()) {
                input.add(scanner.nextInt());
            }
            int[] array = new int[input.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = input.get(i);
            }
            return array;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}

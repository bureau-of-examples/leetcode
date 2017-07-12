package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/longest-absolute-file-path/#/description
 */
public class LongestAbsoluteFilePathTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"), equalTo(32));
        assertThat(solution.lengthLongestPath("dir\n\tb\n\t\t1.txt"), equalTo(11));
        assertThat(solution.lengthLongestPath("dir\n\t1.txt"), equalTo(9));
        assertThat(solution.lengthLongestPath("dir"), equalTo(0));
    }

    public class Solution {
        public int lengthLongestPath(String input) {
            Scanner scanner = new Scanner(input);
            int max = 0;
            Stack<String> pathStack = new Stack<>();
            Stack<Integer> levelStack = new Stack<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int level = getLevel(line);
                String name = line.substring(level);
                String dir = getDir(pathStack, levelStack, level);
                if (name.indexOf('.') >= 0) { //is file
                    max = Math.max(max, dir.length() + name.length() + 1);
                } else {
                    levelStack.push(level);
                    pathStack.push(dir + "/" + name);

                }
            }
            return max == 0 ? 0 : max - 1; //leading '/'
        }

        private String getDir(Stack<String> pathStack, Stack<Integer> levelStack, int newLevel) {
            while (!levelStack.isEmpty() && levelStack.peek() >= newLevel) {
                levelStack.pop();
                pathStack.pop();
            }
            return pathStack.isEmpty() ? "" : pathStack.peek();
        }

        private int getLevel(String path) {
            int count = 0;
            for (char ch : path.toCharArray()) {
                if (ch == '\t')
                    count++;
                else
                    break;
            }
            return count;
        }
    }
}

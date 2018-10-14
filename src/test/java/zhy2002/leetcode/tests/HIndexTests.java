package zhy2002.leetcode.tests;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;


public class HIndexTests {


    private static class Solution {

        private Random rand = new Random(1234);

        public int hIndex(int[] citations) {
            return selectH(citations, 0, citations.length - 1, 0);
        }

        private int selectH(int[] citations, int start, int end, int currentH) {
            if (start > end) {
                return currentH;
            }

            int selected = start + rand.nextInt(end - start + 1);
            int selectedValue = citations[selected];
            int selectedIndex = partition(citations, start, end, selected);
            int tentativeH = currentH + (end - selectedIndex + 1);
            if (selectedValue == tentativeH) {
                return tentativeH;
            } else if (selectedValue > tentativeH) {
                return selectH(citations, start, selectedIndex - 1, tentativeH);
            } else {
                return selectH(citations, selectedIndex + 1, end, currentH);
            }
        }

        private int partition(int[] citations, int start, int end, int selected) {
            swap(citations, selected, end);
            int selectedIndex = end;
            for (int i=end - 1; i>= start; i--) {
                if (citations[i] >= citations[end]) {
                    swap(citations, i, --selectedIndex);
                }
            }
            swap(citations, end, selectedIndex);
            return selectedIndex;
        }

        private void swap(int[] arr, int a, int b) {
            if (a == b)
                return;
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    private static class Solution2 {

        private Random random = new Random(1234);

        public int hIndex(int[] citations) {
            int[] arr = citations;
            int currentH = 0;
            int start = 0, end = arr.length - 1;
            while (start <= end) {
                int selectedIndex = start + random.nextInt(end - start + 1);
                selectedIndex = partition(arr, start, end, selectedIndex);
                int tentativeH = currentH + (end - selectedIndex + 1);
                if (tentativeH == arr[selectedIndex]) {
                    currentH = tentativeH;
                    break;
                }
                if (arr[selectedIndex] > tentativeH) {
                    currentH = tentativeH;
                    end = selectedIndex - 1;
                } else {
                    start = selectedIndex + 1;
                }
            }
            return currentH;
        }

        private int partition(int[] arr, int start, int end, int selectedIndex) {
            swap(arr, selectedIndex, end);
            selectedIndex = end;
            for (int i = end - 1; i >= start; i--) {
                if (arr[i] >= arr[end]) {
                    swap(arr, i, --selectedIndex);
                }
            }
            swap(arr, end, selectedIndex);
            return selectedIndex;
        }

        private void swap(int[] arr, int a, int b) {
            if (a != b) {
                int temp = arr[a];
                arr[a] = arr[b];
                arr[b] = temp;
            }
        }

    }

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(solution.hIndex(new int[] {3,0,6,1,5, 7, 9, 2}), equalTo(4));

        assertThat(new Solution2().hIndex(new int[] {0,1,3,5,6}), equalTo(3));
    }
}

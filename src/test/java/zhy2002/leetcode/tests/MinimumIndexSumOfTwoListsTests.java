package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;


/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class MinimumIndexSumOfTwoListsTests {

    @Test
    public void test() {

        Solution solution = new Solution();
        assertThat(Arrays.asList(
                solution.findRestaurant(
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}
                )
        ), contains("Shogun"));

        solution = new Solution();
        assertThat(Arrays.asList(
                solution.findRestaurant(
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"KFC", "Shogun", "Burger King"}
                )
        ), contains("Shogun"));
    }

    private static class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            if (list1.length > list2.length) {
                String[] temp = list1;
                list1 = list2;
                list2 = temp;
            }
            Map<String, Integer> indices = new HashMap<>();
            for (int i = 0; i < list2.length; i++) {
                indices.put(list2[i], i);
            }

            Set<String> minItems = new HashSet<>();
            int minSum = Integer.MAX_VALUE;
            for (int i = 0; i < list1.length; i++) {
                Integer otherIndex = indices.get(list1[i]);
                if (otherIndex != null) {
                    int sum = i + otherIndex;
                    if (sum < minSum) {
                        minSum = sum;
                        minItems.clear();
                        minItems.add(list1[i]);
                    } else if (sum == minSum) {
                        minItems.add(list1[i]);
                    }
                }
            }

            return minItems.toArray(new String[minItems.size()]);
        }
    }
}

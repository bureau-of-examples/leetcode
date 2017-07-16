package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class DraftTests {

    @Test
    public void test() {
        List<Integer> result = getAnagramIndices("aaa", "");
        assertThat(true, equalTo(true));
    }


    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
    public class Solution {
        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        // RETURN AN EMPTY MATRIX IF PREFERRED LUNCH IS NOT FOUND
        public String[][] matchLunches(String[][] lunchMenuPairs,
                                       String[][] teamCuisinePreference) {
            Set<String> types = new HashSet<>();
            List<String> starMembers = new ArrayList<>();
            Map<String, List<String>> typeToMemberMap = new HashMap<>();
            for (String[] pref : teamCuisinePreference) {
                if ("*".equals(pref[1])) {
                    starMembers.add(pref[0]);
                    continue;
                }
                List<String> members = typeToMemberMap.computeIfAbsent(pref[1], k -> new ArrayList<>());
                members.add(pref[0]);
                types.add(pref[1]);
            }

            Map<String, List<String>> typeToOptionMap = new HashMap<>();
            for (String[] option : lunchMenuPairs) {
                List<String> options = typeToOptionMap.computeIfAbsent(option[1], k -> new ArrayList<>());
                options.add(option[0]);
                types.add(option[1]);
            }

            //add star members
            for (String type : types) {
                List<String> members = typeToMemberMap.get(type);
                if (members == null) {
                    typeToMemberMap.put(type, new ArrayList<>(starMembers));
                } else {
                    members.addAll(starMembers);
                }
            }

            List<String[]> result = new ArrayList<>();
            for (String type : types) {
                List<String> members = typeToMemberMap.get(type);
                List<String> options = typeToOptionMap.get(type);
                if (members == null || options == null)
                    continue;

                join(result, members, options);
            }
            return result.toArray(new String[result.size()][]);
        }
        // METHOD SIGNATURE ENDS

        private void join(List<String[]> result, List<String> members, List<String> options) {
            for (String m : members) {
                for (String o : options) {
                    result.add(new String[]{m, o});
                }
            }
        }
    }

    public List<Integer> getAnagramIndices(String haystack, String needle) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : needle.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        for (int end = 0; end < haystack.length(); end++) {
            char ch = haystack.charAt(end);
            Integer count = countMap.get(ch);
            //minus encountered char
            if (count == null) {
                countMap.put(ch, -1);
            } else {
                if (count == 1) {
                    countMap.remove(ch);
                } else {
                    countMap.put(ch, count - 1);
                }
            }
            if (end - start == needle.length()) {//drop char at start
                char ch2 = haystack.charAt(start++);
                Integer count2 = countMap.get(ch2);
                if (count2 == null) {
                    countMap.put(ch2, 1);
                } else {
                    if (count2 == -1) {
                        countMap.remove(ch2);
                    } else {
                        countMap.put(ch2, count2 + 1);
                    }
                }
            }
            if (countMap.isEmpty()) {
                result.add(start);
            }

        }
        return result;
    }
}

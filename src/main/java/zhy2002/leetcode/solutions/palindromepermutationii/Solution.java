package zhy2002.leetcode.solutions.palindromepermutationii;

import java.util.*;

/**
 * https://leetcode.com/problems/palindrome-permutation-ii/
 * <p>
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
 * For example:
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 */
public class Solution {

    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        String half = getHalf(s);
        if (half != null) {
            String strictHalf = half;
            String center = "";
            if (s.length() % 2 == 1) {
                strictHalf = half.substring(0, half.length() - 1);
                center = half.substring(half.length() - 1);
            }
            permuteUnique(result, strictHalf, center);
        }

        return result;
    }

    private void permuteUnique(List<String> result, String strictHalf, String center) {
        char[] chars = strictHalf.toCharArray();
        Arrays.sort(chars);

        ListNode head = new ListNode('\0'); //sentinel
        ListNode tail = head;
        for (char ch : chars) {
            tail.next = new ListNode(ch);
            tail = tail.next;
        }
        permuteUnique(result, head, head, head.next, center);
    }

    private void permuteUnique(List<String> result, ListNode head, ListNode currentPrevious, ListNode current, String center) {
        if (current == null || current.next == null) {
            addPermutation(result, head, center);
            return;
        }

        ListNode next = current.next;
        ListNode nextPrevious = current;
        permuteUnique(result, head, current, next, center);

        ListNode originalCurrent = current;
        while (next != null) {

            if (next.value != nextPrevious.value) {
                //shift
                nextPrevious.next = next.next;
                currentPrevious.next = next;
                next.next = current;
                current = next;

                permuteUnique(result, head, current, current.next, center);

                //restore
                current = originalCurrent;
                currentPrevious.next = current;
                next.next = nextPrevious.next;
                nextPrevious.next = next;
            }

            nextPrevious = next;
            next = next.next;
        }
    }

    private void addPermutation(List<String> result, ListNode head, String center) {
        StringBuilder sb = new StringBuilder();
        if (head.next != null) {
            head.next.dump(sb);
        }

        String firstHalf = sb.toString();
        sb.reverse();
        String secondHalf = sb.toString();
        result.add(firstHalf + center + secondHalf);
    }

    private String getHalf(String s) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> singles = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (singles.contains(ch)) {
                singles.remove(ch);
                sb.append(ch);
            } else {
                singles.add(ch);
            }
        }

        if (singles.size() > 1)
            return null;
        singles.forEach(sb::append);
        return sb.toString();
    }

    private static class ListNode {
        public char value;
        public ListNode next;

        public ListNode(char ch) {
            this.value = ch;
        }

        void dump(StringBuilder sb) {
            ListNode node = this;
            while (node != null) {
                sb.append(node.value);
                node = node.next;
            }
        }
    }
}

package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.RandomListNode;
import zhy2002.leetcode.solutions.copylistwithrandompointer.HashMapSolution;
import zhy2002.leetcode.solutions.copylistwithrandompointer.InPlaceSolution;
import zhy2002.leetcode.solutions.copylistwithrandompointer.Solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CopyListWithRandomPointerTests {

    @Test
    public void hashMapBasicTest() {
        basicTest(new HashMapSolution());
    }

    @Test
    public void inPlaceBasicTest() {
        basicTest(new InPlaceSolution());
    }

    private void basicTest(Solution solution) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);

        RandomListNode result = solution.copyRandomList(head);
        assertEquals(1, result.label);
        assertEquals(2, result.next.label);
        assertNull(result.random);
        assertNull(result.next.random);

        head.random = head;
        result = solution.copyRandomList(head);
        assertEquals(result, result.random);


    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void heapSortTest() {
        int[] array = new int[]{-10, 5, 4, 7, 3, 8, 2, 6, 1};
        heapSort(array);
        printArray(array);
    }

    private void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private void heapSort(int[] array) {
        buildMaxHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            swap(array, 0, end--);
            heapify(array, end);
        }
    }

    private void heapify(int[] array, int end) {
        int parent = 0;
        while (true) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int maxIndex = parent;
            if (left <= end && array[left] > array[maxIndex]) {
                maxIndex = left;
            }
            if (right <= end && array[right] > array[maxIndex]) {
                maxIndex = right;
            }
            if (parent == maxIndex)
                break;
            swap(array, parent, maxIndex);
            parent = maxIndex;
        }
    }

    private void buildMaxHeap(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int parent = (i - 1) / 2;
            if (array[parent] < array[i]) {
                swap(array, parent, i);
            }
        }
    }
}

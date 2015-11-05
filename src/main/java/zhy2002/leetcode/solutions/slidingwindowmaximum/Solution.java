package zhy2002.leetcode.solutions.slidingwindowmaximum;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * <p>
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3 6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(k == 1 || nums.length == 0)
            return nums;

        //populate queue
        MaxQueue maxQueue = new MaxQueue();
        for(int i=0; i<k; i++){
            maxQueue.enQueue(nums[i]);
        }

        //get first max
        int startIndex = k - 1;
        int[] result = new int[nums.length - startIndex];
        result[0] = maxQueue.getMax();

        //get rest max
        for(int i=k; i<nums.length; i++){
            maxQueue.deQueue();
            maxQueue.enQueue(nums[i]);
            result[i - startIndex] = maxQueue.getMax();
        }
        return result;
    }

}

class MaxQueue {

    //node in queue
    private static class Node {
        public int value;
        public Node next;
    }

    private Node head; //for deQueue
    private Node tail; //for enQueue
    private Deque<Node> maxNodeQueue = new LinkedList<>(); //nodes in maxNodeQueue preserve their relative order in the main queue
    //a node is in maxNodeQueue iff it is the max node in [itself, lastNodeInQueue]

    public void enQueue(int value){

        Node node = new Node();
        node.value = value;
        if(head == null){
            head = tail = node;
            maxNodeQueue.add(node);
        } else {
            tail.next = node;
            tail = node;
            while (!maxNodeQueue.isEmpty() && value >= maxNodeQueue.peekLast().value){
                maxNodeQueue.pollLast();
            }
            maxNodeQueue.add(node);
        }
    }

    public int deQueue(){
        Node node = head;
        head = head.next;
        if(node == maxNodeQueue.peek()){
            maxNodeQueue.poll();
        }
        return node.value;
    }

    public int getMax(){
        return maxNodeQueue.peek().value;
    }
}



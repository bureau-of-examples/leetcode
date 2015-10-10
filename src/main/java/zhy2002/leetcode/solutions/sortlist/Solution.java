package zhy2002.leetcode.solutions.sortlist;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 * Merge log(n) passes, each pass is linear.
 * The first pass the block size is 1, and the second the block size is 2 and so on.
 * Do a pass is linear because we 1) merge is linear; 2) seeking the head of left and right blocks can be done in linear time.
 */
public class Solution {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)//trivial case
            return head;

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        int blockSize = 1;
        int mergeCount;//how many times have we merged left list and right list

        do{//blockSize = 1, 2, 4, 8,...; list length < blockSize
            ListNode leftPrev = newHead;
            mergeCount = 0;

            do{//for every 2 blocks in the list

                //position rightPrev
                ListNode rightPrev = leftPrev;
                for(int i=0; i<blockSize && rightPrev != null; i++){
                    rightPrev = rightPrev.next;
                }

                //there is no right list
                if(rightPrev == null || rightPrev.next == null)
                    break;

                ListNode nextLeft = rightPrev.next;
                for(int i=0; i<blockSize && nextLeft != null; i++){
                    nextLeft = nextLeft.next;
                }

                do{ //merge two blocks
                    if(leftPrev.next.val <= rightPrev.next.val){
                        leftPrev = leftPrev.next;
                    } else {
                        ListNode temp = rightPrev.next;
                        rightPrev.next = temp.next;
                        temp.next = leftPrev.next;
                        leftPrev.next = temp;
                        leftPrev = temp;
                    }
                } while (leftPrev != rightPrev && rightPrev.next != nextLeft);
                while (rightPrev.next != nextLeft){
                    rightPrev = rightPrev.next;
                }
                leftPrev = rightPrev;

                mergeCount++;
            }while (leftPrev != null);


            blockSize <<= 1;
        }while (mergeCount > 0);

        return newHead.next;

    }
}

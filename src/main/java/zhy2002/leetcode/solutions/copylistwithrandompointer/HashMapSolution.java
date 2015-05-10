package zhy2002.leetcode.solutions.copylistwithrandompointer;

import zhy2002.leetcode.common.RandomListNode;

import java.util.HashMap;

/**
 * The obvious solution is to use a hash map.
 */
public class HashMapSolution implements Solution {
    @Override
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;

        HashMap<RandomListNode, RandomListNode> nodeMap = new HashMap<>();
        RandomListNode current = head;
        do{
            RandomListNode clone =new RandomListNode(current.label);//clone all the nodes
            clone.next = current.next;
            clone.random = current.random;
            nodeMap.put(current,clone);
            current = current.next;
        } while(current != null);

        current = head;

        do{
            RandomListNode clone = nodeMap.get(current);//resolve references
            if(clone.next != null)
                clone.next = nodeMap.get(clone.next);

            if(clone.random != null)
                clone.random = nodeMap.get(clone.random);

            current = current.next;
        } while(current != null);

        return nodeMap.get(head);
    }
}

package zhy2002.leetcode.solutions.populatingnextrightpointersineachnodeii;

import zhy2002.leetcode.common.TreeLinkNode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class Solution {

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode levelPointer = root.left == null ? root.right : root.left;
        TreeLinkNode parentPointer = root;

        //loop by level
        while (levelPointer != null) { //first node in this level
            TreeLinkNode nextLevelHead = null, nextLevelHeadParent = null;

            //each node in level
            do {
                //find next level head
                if (nextLevelHead == null) {
                    if (levelPointer.left != null) {
                        nextLevelHead = levelPointer.left;
                        nextLevelHeadParent = levelPointer;
                    } else if (levelPointer.right != null) {
                        nextLevelHead = levelPointer.right;
                        nextLevelHeadParent = levelPointer;
                    }
                }

                //find next in level
                TreeLinkNode levelNextPointer = null;
                if (levelPointer == parentPointer.left && parentPointer.right != null) {
                    levelNextPointer = parentPointer.right;
                } else {
                    parentPointer = parentPointer.next;
                    while (levelNextPointer == null && parentPointer != null) {
                        if (parentPointer.left != null)
                            levelNextPointer = parentPointer.left;
                        else if (parentPointer.right != null)
                            levelNextPointer = parentPointer.right;
                        else
                            parentPointer = parentPointer.next;
                    }
                }

                levelPointer.next = levelNextPointer;
                levelPointer = levelPointer.next;
            } while (levelPointer != null);

            levelPointer = nextLevelHead;
            parentPointer = nextLevelHeadParent;
        }
    }
}

package cn.xxywithpq.广度遍历链表;

import cn.xxywithpq.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode poll = queue.poll();
                if(root.left !=null){
                    queue.add(poll.left);
                }
                if(root.right !=null){
                    queue.add(poll.right);
                }
                size--;
            }
            level++;
        }
        return level;
    }
}



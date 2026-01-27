package cn.xxywithpq.二叉树.二叉树最大深度;

import cn.xxywithpq.TreeNode;

class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		return Math.max(leftMax, rightMax) + 1;
	}
}
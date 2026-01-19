package cn.xxywithpq.二叉树.翻转二叉树;

import cn.xxywithpq.TreeNode;

class Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			invertTree(root.left);
			invertTree(root.right);
			TreeNode leftVal = root.left;
			TreeNode rightVal = root.right;
			root.right = leftVal;
			root.left = rightVal;
		}
		return root;
	}
}
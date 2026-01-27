package cn.xxywithpq.二叉树.二叉树的层序遍历;

import cn.xxywithpq.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

	public List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		ArrayList<List<Integer>> all = new ArrayList<>();
		if (root == null) {
			return all;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			ArrayList<Integer> sub = new ArrayList<>();
			int levelSize = queue.size();

			while (levelSize > 0) {
				TreeNode node = queue.poll();
				sub.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				levelSize--;
			}
			all.add(sub);
		}
		return all;
	}
}
package cn.xxywithpq.二叉树的层序遍历;

import cn.xxywithpq.TreeNode;

import java.util.ArrayList;
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
		ArrayList<List<Integer>> all = new ArrayList();
		ArrayList<Integer> sub1 = new ArrayList();
		sub1.add(root.val);
		all.add(sub1);
		ArrayList<TreeNode> sub = new ArrayList();
		sub.add(root.left);
		sub.add(root.right);
		doLevelOrder(all, sub);
		return all;

	}

	public void doLevelOrder(ArrayList<List<Integer>> all, ArrayList<TreeNode> sub) {

		if (sub == null || sub.isEmpty()) {
			return;
		}

		ArrayList<TreeNode> ssub = new ArrayList<>();
		ArrayList<Integer> sub1 = new ArrayList();
		for (TreeNode treeNode : sub) {
			sub1.add(treeNode.val);

			if (treeNode.left != null) {
				ssub.add(treeNode.left);
			}
			if (treeNode.right != null) {
				ssub.add(treeNode.right);
			}
		}

		doLevelOrder(all, ssub);

	}
}
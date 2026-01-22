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
		if(root == null){
			return all;
		}
		queue.add(root);
		doLevelOrder(all, queue);
		return all;
	}

	public void doLevelOrder(ArrayList<List<Integer>> all, LinkedList<TreeNode> queue) {
		if (queue.isEmpty()) {
			return;
		}
		ArrayList<Integer> sub = new ArrayList<>();
		LinkedList<TreeNode> queueNext = new LinkedList<>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			sub.add(node.val);
			if (node.left != null) {
				queueNext.add(node.left);
			}
			if (node.right != null) {
				queueNext.add(node.right);
			}
		}
		all.add(sub);
		doLevelOrder(all, queueNext);

	}
}
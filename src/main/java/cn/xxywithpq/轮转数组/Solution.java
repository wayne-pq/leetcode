package cn.xxywithpq.轮转数组;

class Solution {
	public void rotate(int[] nums, int k) {
		int[] newNums = new int[nums.length];
		int a = k;
		if (k > nums.length) {
			a = k % nums.length;
		}
		if (a == 0) {
			return;
		}
		int mid = nums.length - a;
		int i = 0;
		int aa = mid;
		while (aa < nums.length) {
			newNums[i++] = nums[aa++];
		}
		int j = 0;
		while (j < mid) {
			newNums[i++] = nums[j++];
		}
		System.arraycopy(newNums, 0, nums, 0, nums.length);
	}
}
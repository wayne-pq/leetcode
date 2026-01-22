package cn.xxywithpq.轮转数组;

class Solution {
	public void rotate(int[] nums, int k) {
		int[] newNums = new int[nums.length];
		int size = nums.length;

		for (int i = 0; i < size; i++) {
			int newIndex = (i + k) % size;
			newNums[newIndex] = nums[i];
		}
		System.arraycopy(newNums, 0, nums, 0, size);
	}
}
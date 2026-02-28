package cn.xxywithpq.两数之和;

import java.util.HashMap;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> cache = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (cache.containsKey(target - nums[i])) {
				return new int[] { i, cache.get(target - nums[i]) };
			} else {
				cache.put(nums[i], i);
			}
		}
		return null;
	}
}
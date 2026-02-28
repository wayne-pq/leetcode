package cn.xxywithpq.左右指针.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int pre = nums[i];
			int start = i + 1;
			int end = nums.length - 1;

			while (start < end) {
				int total = nums[start] + nums[end] + pre;
				if (total == 0) {
					result.add(Arrays.asList(pre, nums[start], nums[end]));

					while (start < end && nums[start] == nums[start + 1]) {
						start++;
					}
					while (start < end && nums[end] == nums[end - 1]) {
						end--;
					}
					start++;
					end--;
				} else if (total > 0) {
					end--;
				} else {
					start++;
				}
			}
		}
		return result;
	}
}
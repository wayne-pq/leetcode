package cn.xxywithpq.最长递增子序列;

class Solution {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int maxmax = 0;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			maxmax = Math.max(dp[i], maxmax);
		}
		return maxmax+1;
	}

	public static void main(String[] args) {
		int[] a = {1, 3, 6, 7, 9, 4, 10, 5, 6};
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLIS(a));
	}
}
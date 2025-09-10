package cn.xxywithpq.接雨水;

class Solution {
	public int trap(int[] height) {
		int count = 0;

		for (int i = 0; i < height.length; i++) {
			int ownHeight = height[i];
			int leftHeight = ownHeight;
			int leftHeightIdx = i;
			int rightHeight = ownHeight;
			int rightHeightIdx = i;
			while (leftHeightIdx >= 0) {
				if (leftHeight < height[leftHeightIdx]) {
					leftHeight = height[leftHeightIdx];
				}
				leftHeightIdx--;
			}

			while (rightHeightIdx < height.length) {
				if (rightHeight < height[rightHeightIdx]) {
					rightHeight = height[rightHeightIdx];
				}
				rightHeightIdx++;
			}

			count += Math.max((Math.min(leftHeight, rightHeight) - height[i]), 0);
		}
		return count;
	}

	public static void main(String[] args) {
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(new Solution().trap(height));
	}
}
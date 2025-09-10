package cn.xxywithpq.接雨水;

class Solution1 {
	public int trap(int[] height) {
		int count = 0;
		int leftHeightIdx = 0;
		int leftHeight = height[leftHeightIdx];
		int rightHeightIdx = height.length - 1;
		int rightHeight = height[rightHeightIdx];

		while (leftHeightIdx < rightHeightIdx) {
			if (height[leftHeightIdx] < height[rightHeightIdx]) {
				if (height[leftHeightIdx] > leftHeight) {
					leftHeight = height[leftHeightIdx];
				}
				count += Math.max((leftHeight - height[leftHeightIdx]), 0);
				leftHeightIdx++;
			} else {
				if (height[rightHeightIdx] > rightHeight) {
					rightHeight = height[rightHeightIdx];
				}
				count += Math.max((rightHeight - height[rightHeightIdx]), 0);
				rightHeightIdx--;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(new Solution1().trap(height));
	}
}
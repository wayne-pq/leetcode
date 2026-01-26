package cn.xxywithpq.左右指针.盛最多水的容器;

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            // 计算当前面积
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, currentArea);

            // 移动较短的那根线
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
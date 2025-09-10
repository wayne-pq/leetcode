package cn.xxywithpq.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		ArrayList<int[]> result = new ArrayList<>();
		Stack<int[]> stack = new Stack<>();
		int length = intervals.length;
		for (int i = 0; i < length; i++) {
			if (stack.isEmpty()) {
				stack.push(intervals[i]);
			} else {
				int[] temp = stack.peek();
				if ((intervals[i][0] <= temp[1] && intervals[i][0] >= temp[0])
						|| (intervals[i][1] <= temp[1] && intervals[i][1] >= temp[0])
						|| (intervals[i][1] >= temp[1] && intervals[i][0] <= temp[0])
						|| (intervals[i][1] <= temp[1] && intervals[i][0] >= temp[0])) {
					temp[0] = Math.min(temp[0], intervals[i][0]);
					temp[1] = Math.max(temp[1], intervals[i][1]);
					stack.pop();
					stack.push(temp);
				} else {
					stack.push(intervals[i]);
				}
			}
		}
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		return result.toArray(new int[result.size()][2]);
	}

	public static void main(String[] args) {
		int[][] intervals = {{1, 4}, {0, 5}};
		int[][] merge = new Solution().merge(intervals);
		for (int[] ints : merge) {
			System.out.println(ints[0] + " " + ints[1]);
		}
	}
}
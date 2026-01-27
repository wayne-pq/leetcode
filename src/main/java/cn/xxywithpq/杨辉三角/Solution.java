package cn.xxywithpq.杨辉三角;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 1; i <= numRows; i++) {
			List<Integer> dd = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				if (j == 0) {
					dd.add(1);
				} else if (j == i - 1) {
					dd.add(1);
				} else {
					List<Integer> upp = list.get(list.size() - 1);
					dd.add(upp.get(j - 1) + upp.get(j));
				}
			}
			list.add(dd);
		}
		return list;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> generate = solution.generate(5);
		System.out.println(generate);
	}
}
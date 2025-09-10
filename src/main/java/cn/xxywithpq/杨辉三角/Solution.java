package cn.xxywithpq.杨辉三角;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<Integer>> generate(int numRows) {
		ArrayList<List<Integer>> list = new ArrayList();
		int n = 1;
		while (numRows > 0) {

			List<Integer> temp = new ArrayList(n);

			for (int i = 0; i < n; i++) {
				if (i == 0) {
					temp.add(1);
					continue;
				}
				if (i == (n - 1)) {
					temp.add(1);
					continue;
				}

				int left = list.get(n - 2).get(i - 1);
				int right = list.get(n - 2).get(i);
				temp.add(left + right);
			}
			list.add(temp);
			n++;
			numRows--;
		}
		return list;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> generate = solution.generate(1);
		System.out.println(generate);
	}
}
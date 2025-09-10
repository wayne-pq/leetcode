package cn.xxywithpq.最长公共子序列;

class Solution {
	public int longestCommonSubsequence(String text1, String text2) {
		char[] charArray = text1.toCharArray();
		char[] charArray2 = text2.toCharArray();

		int[][] ints = new int[charArray.length + 1][charArray2.length + 1];

		for (int i = 1; i < charArray.length + 1; i++) {
			for (int j = 1; j < charArray2.length + 1; j++) {
				if (charArray[i - 1] == charArray2[j - 1]) {
					ints[i][j] = ints[i - 1][j - 1] + 1;
				} else {
					ints[i][j] = Math.max(ints[i - 1][j], ints[i][j - 1]);
				}
			}
		}
		return ints[charArray.length][charArray2.length];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().longestCommonSubsequence("abcde", "abcde"));
	}
}

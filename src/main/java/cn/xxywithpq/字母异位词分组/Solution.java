package cn.xxywithpq.字母异位词分组;

import java.util.*;

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] tempArr = str.toCharArray();
			Arrays.sort(tempArr);
			String tempStr = new String(tempArr);
			if (map.containsKey(tempStr)) {
				List<String> list = map.get(tempStr);
				list.add(str);
			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(tempStr, list);
			}
		}

		return new ArrayList<>(map.values());
	}


	public List<List<String>> groupAnagrams2(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			int[] count = new int[26];
			for (char c : str.toCharArray()) {
				count[c - 'a']++;
			}

			String key = new String(count,0,26);
			map.computeIfAbsent(key,k->new ArrayList<>()).add(str);
		}

		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		new Solution().groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
	}
}
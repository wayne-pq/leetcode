package cn.xxywithpq.栈.有效的括号;

import java.util.HashMap;
import java.util.Stack;

class Solution {
	public boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		char[] sArr = s.toCharArray();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < sArr.length; i++) {
			if (map.containsKey(sArr[i])) {
				stack.push(sArr[i]);
			} else {
				if (stack.isEmpty() || sArr[i] != map.get(stack.pop())) {
					return false;
				}
			}
		}

		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}
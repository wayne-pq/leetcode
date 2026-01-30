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

		for (char c : sArr) {
			if (map.containsKey(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty() || c != map.get(stack.pop())) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}
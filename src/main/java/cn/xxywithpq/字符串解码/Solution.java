package cn.xxywithpq.字符串解码;

import java.math.BigDecimal;
import java.util.Stack;

class Solution {
	public static String decodeString(String s) {
		Stack stack = new Stack();
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		Integer multi = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 'a' && chars[i] <= 'z') {
				sb.append(chars[i]);
			}
			if (chars[i] >= '0' && chars[i] <= '9') {
				Integer tempInt = Integer.valueOf(String.valueOf(chars[i]));
				multi = multi * 10 + tempInt;
				if (sb.length() > 0) {
					stack.push(sb.toString());
					sb.setLength(0);
				}
			}
			if (chars[i] == '[') {
				stack.push(multi);
				multi = 0;
			}
			if (chars[i] == ']') {
				Integer tempMulti = (Integer) stack.pop();
				String tempStr = sb.toString();
				while (tempMulti > 1) {
					sb.append(tempStr);
					tempMulti--;
				}
				if(stack.size() > 0){
					String stackStr = (String) stack.pop();
					sb.insert(0, stackStr);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
//		System.out.println(decodeString("3[a10[bc]]"));
		BigDecimal bigDecimal = new BigDecimal("123.456789012345");
		System.out.println(bigDecimal.stripTrailingZeros().toPlainString());
	}
}
package cn.xxywithpq.字符串解码;

class Solution2 {
	public static int i = 0;

	public String decodeString(String s) {
		char[] arr = s.toCharArray();
		String result = doDecodeString(arr,0);
		i = 0;
		return result;
	}

	public String doDecodeString(char[] arr, int preMulti) {
		int multi = 0;
		StringBuilder sb = new StringBuilder();
		while (i < arr.length) {
			char a = arr[i];
			if (a >= '0' && a <= '9') {
				multi = Integer.parseInt(String.valueOf(a)) + multi * 10;
			} else if (a == '[') {
				i++;
				sb.append(doDecodeString(arr, multi));
				multi = 0;
			} else if (a >= 'a' && a <= 'z') {
				sb.append(a);
			} else if (a == ']') {
				String s = sb.toString();
				while (preMulti-- > 1) {
					sb.append(s);
				}
				return sb.toString();
			}
			i++;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String decodeString = new Solution2().decodeString("3[a2[c]]");
		System.out.println(decodeString);
	}
}
package count_and_say;

public class Solution {
	public String countAndSay(int n) {
		String str = "1";
		while (--n > 0) {
			str = this.generate(str);
		}
		return str;
	}

	private String generate(String str) {
		int len = str.length();
		StringBuilder builder = new StringBuilder();
		for (int start = 0, end = 1; end <= len; end++) {
			if (end == len || str.charAt(end) != str.charAt(start)) {
				builder.append(end - start);
				builder.append(str.charAt(start));
				start = end;
			}
		}
		return builder.toString();
	}
}

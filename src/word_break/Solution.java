package word_break;

import java.util.*;

public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
		int length = s.length();

		//breakable[i] means whether s.substring(0, i) can break or not.
		boolean[] breakable = new boolean[length + 1];

		//suppose an empty string is always breakable.
		breakable[0] = true;

		//determine whether s.substring(0, len) can break or not.
		//s.substring(0, len) is breakable if exist i in range [0, len) that
		// s.substring(0, i) can break and dict contains s.substring(i)
		for (int len = 1; len <= length; len++) {
			for (int i = 0; !breakable[len] && i < len; i++) {
				breakable[len] = breakable[i] && dict.contains(s.substring(i, len));
			}
		}

		return breakable[length];
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		System.out.println(new Solution().wordBreak("leetcodes", dict));
	}
}
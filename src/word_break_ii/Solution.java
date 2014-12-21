package word_break_ii;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
	@SuppressWarnings("unchecked")
	public List<String> wordBreak(String s, Set<String> dict) {
		//early check to avoid some worst case
		if (!this.canBreak(s, dict)) {
			return new LinkedList<>();
		}
		int length = s.length();
		List<String>[] results = (List<String>[]) Array.newInstance(List.class, length + 1);
		for (int i = 1; i <= length; i++) {
			results[i] = new LinkedList<>();
		}
		for (int end = 1; end <= length; end++) {
			for (int begin = 0; begin < end; begin++) {
				String substring = s.substring(begin, end);
				if (dict.contains(substring)) {
					if (begin == 0) {
						results[end].add(substring);
					} else {
						for (String str : results[begin]) {
							results[end].add(str + ' ' + substring);
						}
					}
				}
			}
		}
		return results[length];
	}

	private boolean canBreak(String s, Set<String> dict) {
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
		dict.add("a");
		dict.add("aa");
		dict.add("ab");
		System.out.println(new Solution().wordBreak("baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", dict));
	}
}

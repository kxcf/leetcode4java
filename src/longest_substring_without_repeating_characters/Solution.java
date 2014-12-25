package longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		int start = 0;
		Map<Character, Integer> record = new HashMap<>(256);
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			Integer pos = record.get(ch);
			start = Math.max(start, pos == null ? 0 : pos + 1);
			maxLen = Math.max(i - start + 1, maxLen);
			record.put(ch, i);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
	}
}
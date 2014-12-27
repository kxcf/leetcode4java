package anagrams.v2;

import java.util.*;

public class Solution {
	public List<String> anagrams(String[] strs) {
		List<String> result = new LinkedList<>();
		Map<String, String> dict = new HashMap<>(strs.length);
		String isAnagram = "isAnagram";
		for (String str : strs) {
			String gid = this.getGid(str);
			String flag = dict.get(gid);
			if (flag == null) {
				dict.put(gid, str);
			} else {
				if (flag != isAnagram) {
					result.add(flag);
					dict.put(gid, isAnagram);
				}
				result.add(str);
			}
		}
		return result;
	}

	private String getGid(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().anagrams(new String[]{"a", "a"}));
	}
}

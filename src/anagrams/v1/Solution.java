package anagrams.v1;

import java.util.*;

public class Solution {
	public List<String> anagrams(String[] strs) {
		List<String> result = new LinkedList<>();
		Map<String, List<String>> groups = new HashMap<>(strs.length);
		for (String str : strs) {
			String gid = this.getGid(str);
			List<String> group = groups.get(gid);
			if (group == null) {
				group = new LinkedList<>();
				groups.put(gid, group);
			}
			group.add(str);
		}
		for (List<String> group : groups.values()) {
			if (group.size() > 1) {
				result.addAll(group);
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

package combination_sum_ii.v1;

import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		return this.combination(num, num.length, target);
	}

	private List<List<Integer>> combination(int[] num, int len, int target) {
		List<List<Integer>> result = new LinkedList<>();
		if (target == 0) {
			result.add(new LinkedList<Integer>());
		} else {
			for (int i = 0; i < len && num[i] <= target; i++) {
				if (i + 1 < len && num[i] == num[i + 1]) {
					continue;
				}
				for (List<Integer> integers : this.combination(num, i, target - num[i])) {
					integers.add(num[i]);
					result.add(integers);
				}
			}
		}
		return result;
	}
}
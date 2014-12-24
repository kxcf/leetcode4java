package combination_sum.v1;

import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return this.combination(candidates, candidates.length, target);
	}

	private List<List<Integer>> combination(int[] candidates, int len, int target) {
		List<List<Integer>> result = new LinkedList<>();
		if (target == 0) {
			result.add(new LinkedList<Integer>());
		} else {
			for (int i = 0; i < len && candidates[i] <= target; i++) {
				for (List<Integer> integers : this.combination(candidates, i + 1, target - candidates[i])) {
					integers.add(candidates[i]);
					result.add(integers);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
	}
}
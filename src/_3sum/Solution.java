package _3sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new LinkedList<>();
		for (int i = num.length - 1; i > 1; i--) {
			if (i + 1 < num.length && num[i] == num[i + 1]) {
				continue;
			}
			for (int j = 0, k = i - 1; j < k; ) {
				int sum = num[j] + num[k] + num[i];
				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					result.add(Arrays.asList(num[j], num[k], num[i]));
					do {
						j++;
						k--;
					} while (j < k && num[j - 1] == num[j] && num[k] == num[k + 1]);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().threeSum(new int[]{0, 0, 0, 0, 0, 0, 0}));
	}
}

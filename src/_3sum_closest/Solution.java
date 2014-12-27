package _3sum_closest;

import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int min = num[0] + num[1] + num[2];
		for (int i = num.length - 1; i > 1; i--) {
			int j = 0;
			int k = i - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				if (Math.abs(sum - target) < Math.abs(min - target)) {
					min = sum;
				}
				if (sum < target) {
					j++;
				} else if (sum > target) {
					k--;
				} else {
					break;
				}
			}
		}
		return min;
	}
}

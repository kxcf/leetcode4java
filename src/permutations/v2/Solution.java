package permutations.v2;

import java.util.*;

public class Solution {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new LinkedList<>();

		//turn int[] into Integer[]
		Integer[] integers = Solution.toObject(num);

		Solution.generate(integers, 0, result);
		return result;
	}

	private static void generate(Integer[] integers, int pos, List<List<Integer>> result) {
		if (pos == integers.length - 1) {
			result.add(Arrays.asList(integers));
		} else {
			for (int i = pos; i < integers.length; i++) {
				Solution.swap(integers, pos, i);
				Solution.generate(integers.clone(), pos + 1, result);
			}
		}
	}

	private static Integer[] toObject(int[] num) {
		Integer[] integers = new Integer[num.length];
		for (int i = 0; i < integers.length; i++) {
			integers[i] = num[i];
		}
		return integers;
	}

	private static void swap(Integer[] integers, int a, int b) {
		if (a != b) {
			Integer temp = integers[a];
			integers[a] = integers[b];
			integers[b] = temp;
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().permute(new int[]{1, 2, 3}));
	}
}

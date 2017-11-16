package counting_bits;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author vision
 * @since 2017/10/10 下午7:37
 */
public class Solution {
	public static void main(String[] args) {
		System.out.println(Arrays.stream(new Solution().countBits(10)).boxed().map(Object::toString)
				.collect(Collectors.joining(",")));
	}

	public int[] countBits(int num) {
		int[] r = new int[num + 1];
		for (int i = 1; i <= num; ++i) {
			r[i] = r[i >> 1] + (i & 1);
		}
		return r;
	}
}

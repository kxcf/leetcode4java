package divide_two_integers.v1;

public class Solution {
	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		//sign of the final result.
		boolean positive = true;

		//turn both number to negative because negative is　wider.
		if (dividend > 0) {
			dividend = -dividend;
			positive = !positive;
		}
		if (divisor > 0) {
			divisor = -divisor;
			positive = !positive;
		}

		//
		int temp = divisor;
		while ((dividend >> 1) <= temp) {
			temp <<= 1;
		}

		int value = 0;
		while (divisor > temp) {
			value <<= 1;
			if (dividend <= temp) {
				value |= 1;
				dividend -= temp;
			}
			temp >>= 1;
		}
		value = (value << 1) | (temp >= dividend ? 1 : 0);
		if (positive && value == Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		return positive ? value : -value;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().divide(Integer.MIN_VALUE, -2));
	}
}

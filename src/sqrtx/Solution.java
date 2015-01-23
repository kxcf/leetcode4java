package sqrtx;

public class Solution {
	public int sqrt(int y) {

		//initial guess
		long x = y >> 1;

		//see explanations in README.md.
		for (long dy; (dy = x * x - y) > 0; x -= (dy - 1) / (x << 1) + 1);

		//x must be ⌊√y⌋ here, except when y == 1
		return y == 1 ? 1 : (int)x;
	}
}

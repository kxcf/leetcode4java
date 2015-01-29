package reverse_integer;

public class Solution {
	public int reverse(int x) {
		long r = 0;
		while (x != 0) {
			r = r * 10 + x % 10;
			x /= 10;
		}
		return r > Integer.MAX_VALUE || r < Integer.MIN_VALUE ? 0 : (int) r;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().reverse(1563847412));
	}
}

package fraction_to_recurring_decimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder builder = new StringBuilder();
		if (numerator != 0 && ((numerator > 0) ^ (denominator > 0))) {
			builder.append('-');
		}
		long n = Math.abs((long) numerator);
		long d = Math.abs((long) denominator);
		builder.append(n / d);
		n %= d;
		if (n != 0) {
			builder.append('.');
			Map<Long, Integer> dict = new HashMap<>();
			while (n != 0 && !dict.containsKey(n)) {
				dict.put(n, builder.length());
				n *= 10;
				builder.append(n / d);
				n %= d;
			}
			if (n != 0) {
				builder.insert(dict.get(n), "(");
				builder.append(")");
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().fractionToDecimal(0, 3));
	}
}

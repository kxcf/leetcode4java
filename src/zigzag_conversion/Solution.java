package zigzag_conversion;

public class Solution {
	/*
	0    [         totalGap           ]       6                                         c
	1    [  totalGap-2row  ]    5   [ 2row ]  7                           b             d
	2             4                           8             a                           e
	3                                         9                                         f
	*/
	public String convert(String s, int nRows) {
		if (nRows == 1) {
			return s;
		}
		int len = s.length();
		StringBuilder builder = new StringBuilder(len);
		int totalGap = (nRows - 1) << 1;
		for (int i = 0; i < len; i += totalGap) {
			builder.append(s.charAt(i));
		}
		for (int row = 1; row < nRows - 1; row++) {
			for (int i = row, gap = row << 1; i < len; gap = totalGap - gap, i += gap) {
				builder.append(s.charAt(i));
			}
		}
		for (int i = nRows - 1; i < len; i += totalGap) {
			builder.append(s.charAt(i));
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().convert("ABCD", 4));
	}
}

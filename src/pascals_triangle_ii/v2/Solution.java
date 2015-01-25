package pascals_triangle_ii.v2;

import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		Integer[] integers = new Integer[rowIndex + 1];
		integers[0] = 1;
		for (int col = 1; col <= rowIndex; col++) {
			integers[col] = (int)((long)integers[col - 1] * (rowIndex - col + 1) / col);
		}
		return Arrays.asList(integers);
	}
}

package pascals_triangle_ii.v1;

import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		Integer[] integers = new Integer[rowIndex + 1];
		Arrays.fill(integers, 1);
		for (int row = 0; row < rowIndex; row++) {
			for (int col = row; col > 0; col--) {
				integers[col] += integers[col - 1];
			}
		}
		return Arrays.asList(integers);
	}
}

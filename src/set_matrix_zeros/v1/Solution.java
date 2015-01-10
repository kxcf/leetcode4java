package set_matrix_zeros.v1;

import java.util.Arrays;

public class Solution {
	public void setZeroes(int[][] matrix) {
		int height = matrix.length, width = matrix[0].length;
		boolean aboveLineHasZero = this.contains(matrix[0], 0);
		for (int row = 1; row < height; row++) {
			boolean currentLineHasZero = this.contains(matrix[row], 0);

			for (int col = 0; col < width; col++) {
				if (matrix[row - 1][col] == 0) {
					matrix[row][col] = 0;
				} if (matrix[row][col] == 0) {
					for (int i = 0; i < row; i++) {
						matrix[i][col] = 0;
					}
				}
			}

			if (aboveLineHasZero) {
				Arrays.fill(matrix[row - 1], 0);
			}
			aboveLineHasZero = currentLineHasZero;
		}
		if (aboveLineHasZero) {
			Arrays.fill(matrix[height - 1], 0);
		}
	}

	private boolean contains(int[] integers, int target) {
		for (int i : integers) {
			if (target == i) {
				return true;
			}
		}
		return false;
	}
}

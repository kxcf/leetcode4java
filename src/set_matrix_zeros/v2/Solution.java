package set_matrix_zeros.v2;

public class Solution {
	public void setZeroes(int[][] matrix) {
		int height = matrix.length, width = matrix[0].length;
		boolean col0 = false;
		for (int row = 0; row < height; row++) {
			col0 |= (matrix[row][0] == 0);
			for (int col = 1; col < width; col++) {
				if (matrix[row][col] == 0) {
					matrix[row][0] = matrix[0][col] = 0;
				}
			}
		}
		for (int row = height - 1; row >= 0; row--) {
			for (int col = width - 1; col > 0; col--) {
				if (matrix[0][col] == 0 || matrix[row][0] == 0) {
					matrix[row][col] = 0;
				}
			}
			if (col0) {
				matrix[row][0] = 0;
			}
		}
	}
}

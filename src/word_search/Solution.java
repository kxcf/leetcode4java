package word_search;

public class Solution {
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (this.exist(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean exist(char[][] board, int row, int col, String word, int pos) {
		if (pos == word.length()) {
			return true;
		}
		if (row == -1 || row == board.length || col == -1 || col == board[row].length || board[row][col] != word.charAt(pos)) {
			return false;
		}
		char temp = board[row][col];
		board[row][col] = '\0';
		boolean ok = this.exist(board, row + 1, col, word, pos + 1) ||
				this.exist(board, row - 1, col, word, pos + 1) ||
				this.exist(board, row, col + 1, word, pos + 1) ||
				this.exist(board, row, col - 1, word, pos + 1);
		board[row][col] = temp;
		return ok;
	}
}
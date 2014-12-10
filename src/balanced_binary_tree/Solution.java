package balanced_binary_tree;

/**
 * TreeNode is not part of solution, should comment out.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public boolean isBalanced(TreeNode root) {
		return this.getHeight(root) >= 0;
	}

	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = this.getHeight(root.left);
		if (left < 0) {
			return -1;
		}
		int right = this.getHeight(root.right);
		if (right < 0) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return 1 + Math.max(left, right);
	}
}

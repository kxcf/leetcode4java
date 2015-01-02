package sum_root_to_leaf_numbers;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public int sumNumbers(TreeNode root) {
		return this.sum(root, 0);
	}

	private int sum(TreeNode root, int temp) {
		if (root == null) {
			return 0;
		}
		temp = temp * 10 + root.val;
		if (root.left == null && root.right == null) {
			return temp;
		}
		return this.sum(root.left, temp) + this.sum(root.right, temp);
	}
}

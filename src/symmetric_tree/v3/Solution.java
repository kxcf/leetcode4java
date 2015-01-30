package symmetric_tree.v3;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public boolean isSymmetric(TreeNode root) {
		return this.isMirror(root, root);
	}

	private boolean isMirror(TreeNode t0, TreeNode t1) {
		while (t0 != null && t1 != null) {
			if (t0.val != t1.val || !this.isMirror(t0.left, t1.right)) {
				return false;
			}
			t0 = t0.right;
			t1 = t1.left;
		}
		return t0 == t1;
	}
}

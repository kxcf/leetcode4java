package symmetric_tree.v1;

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

	private boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null || t2 == null) {
			return t1 == t2;
		}
		return t1.val == t2.val && this.isMirror(t1.left, t2.right) && this.isMirror(t1.right, t2.left);
	}
}

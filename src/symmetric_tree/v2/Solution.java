package symmetric_tree.v2;

import java.util.Deque;
import java.util.LinkedList;

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
		Deque<TreeNode[]> stack = new LinkedList<>();
		stack.push(new TreeNode[]{root, root});
		while (!stack.isEmpty()) {
			TreeNode[] pair = stack.pop();
			TreeNode t0 = pair[0], t1 = pair[1];
			if (t0 == null && t1 == null) {
				continue;
			}
			if (t0 == null || t1 == null || t0.val != t1.val) {
				return false;
			}
			stack.push(new TreeNode[]{t0.left, t1.right});
			stack.push(new TreeNode[]{t0.right, t1.left});
		}
		return true;
	}
}

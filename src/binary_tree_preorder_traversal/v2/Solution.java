package binary_tree_preorder_traversal.v2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				result.add(node.val);
				stack.push(node.right);
				node = node.left;
			} else {
				node = stack.pop();
			}
		}
		return result;
	}
}

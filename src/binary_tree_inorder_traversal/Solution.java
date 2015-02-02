package binary_tree_inorder_traversal;

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
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				result.add(stack.peek().val);
				node = stack.pop().right;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		n0.right = n1;
		n1.left = n2;
		System.out.println(new Solution().inorderTraversal(n0));
	}
}

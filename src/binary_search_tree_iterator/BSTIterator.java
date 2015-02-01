package binary_search_tree_iterator;

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

public class BSTIterator {

	private Deque<TreeNode> stack = new LinkedList<>();

	public BSTIterator(TreeNode root) {
		this.pushLeft(root);
	}

	private void pushLeft(TreeNode root) {
		for (TreeNode node = root; node != null; node = node.left) {
			this.stack.push(node);
		}
	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return !this.stack.isEmpty();
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		TreeNode nextNode = this.stack.pop();
		this.pushLeft(nextNode.right);
		return nextNode.val;
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

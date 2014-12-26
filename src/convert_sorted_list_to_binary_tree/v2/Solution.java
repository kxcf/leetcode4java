package convert_sorted_list_to_binary_tree.v2;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {

	private ListNode current;

	public TreeNode sortedListToBST(ListNode head) {
		this.current = head;
		return this.convert(this.getSize(head));
	}

	//covert len ListNode from current into Tree and return it's root.
	private TreeNode convert(int len) {
		if (len == 0) {
			return null;
		}
		TreeNode root = new TreeNode(0);
		root.left = convert(len >> 1);
		root.val = this.current.val;
		this.current = this.current.next;
		root.right = convert(len - (len >> 1) - 1);
		return root;
	}

	private int getSize(ListNode head) {
		int size = 0;
		while (head != null) {
			head = head.next;
			size++;
		}
		return size;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		int i = 2;
		for (ListNode node = head; i < 16; node = node.next) {
			node.next = new ListNode(i++);
		}
		new Solution().sortedListToBST(head);
	}
}

package convert_sorted_list_to_binary_tree;

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
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode prevHead = new ListNode(0);
		prevHead.next = head;
		ListNode slow = prevHead;

		//or prevHead.next
		for (ListNode fast = head.next; fast != null && fast.next != null; ) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		TreeNode root = new TreeNode(mid.val);
		root.left = this.sortedListToBST(prevHead.next);
		root.right = this.sortedListToBST(mid.next);
		return root;
	}
}

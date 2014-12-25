package sort_list.v2;

/**
 * ListNode is not part of solution, should comment out.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		for (ListNode fast = head.next; fast != null && fast.next != null; ) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		return this.merge(this.sortList(head), this.sortList(mid));
	}

	private ListNode merge(ListNode first, ListNode second) {
		ListNode pseudoHead = new ListNode(0);
		ListNode merged = pseudoHead;
		while (first != null && second != null) {
			if (first.val < second.val) {
				merged.next = first;
				first = first.next;
			} else {
				merged.next = second;
				second = second.next;
			}
			merged = merged.next;
		}
		merged.next = first != null ? first : second;
		return pseudoHead.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		ListNode node = new ListNode(1);
		head.next = node;
		new Solution().sortList(head);
	}
}

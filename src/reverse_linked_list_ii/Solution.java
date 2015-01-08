package reverse_linked_list_ii;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode pseudo = new ListNode(0);
		pseudo.next = head;
		ListNode prevM = pseudo;
		for (int i = 1; i < m; i++) {
			prevM = prevM.next;
		}
		ListNode tail = prevM.next;
		while (m++ < n) {
			ListNode node = tail.next;
			tail.next = node.next;
			node.next = prevM.next;
			prevM.next = node;
		}
		return pseudo.next;
	}
}

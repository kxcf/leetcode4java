package insertion_sort_list;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode insertionSortList(ListNode head) {
		ListNode pseudo = new ListNode(0);
		pseudo.next = head;
		for (ListNode i = pseudo; i.next != null; i = i.next) {
			ListNode min = i;
			for (ListNode j = i.next; j.next != null; j = j.next) {
				if (j.next.val < min.next.val) {
					min = j;
				}
			}
			if (min != i) {
				ListNode temp = i.next;
				i.next = min.next;
				min.next = temp;
				temp = i.next.next;
				i.next.next = min.next.next;
				min.next.next = temp;
			}
		}
		return pseudo.next;
	}
}

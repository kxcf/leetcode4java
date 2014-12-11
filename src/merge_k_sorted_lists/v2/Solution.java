package merge_k_sorted_lists.v2;

import java.util.List;

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

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0) {
			return null;
		}
		if (lists.size() == 1) {
			return lists.get(0);
		}
		return this.merge(this.mergeKLists(lists.subList(0, lists.size() / 2)),
				this.mergeKLists(lists.subList(lists.size() / 2, lists.size())));
	}

	private final ListNode tempPseudoHead = new ListNode(0);

	private ListNode merge(ListNode first, ListNode second) {
		ListNode merged = this.tempPseudoHead;
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
		return this.tempPseudoHead.next;
	}
}

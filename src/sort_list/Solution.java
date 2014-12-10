package sort_list;

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
		final ListNode pseudoHead = new ListNode(0);
		pseudoHead.next = head;

		//length of 'head'
		long listSize = this.getSize(head);

		for (long len = 1; len < listSize; len <<= 1) {

			//merge every two 'len'-length sublist
			for (ListNode merged = pseudoHead; merged.next != null; ) {

				//the first sublist to be merged
				ListNode first = merged.next;

				//the second sublist to be merged
				ListNode second = this.step(first, len);

				//'merged' is the last node of the merged list
				merged = this.merge(merged, first, second, len);
			}
		}
		return pseudoHead.next;
	}

	/**
	 * calculate the length of 'node'.
	 */
	private long getSize(ListNode node) {
		long i = 0;
		while (node != null) {
			i++;
			node = node.next;
		}
		return i;
	}

	/**
	 * step forward for n steps from node.
	 */
	private ListNode step(ListNode node, long n) {
		for (long j = 0; j < n && node != null; j++) {
			node = node.next;
		}
		return node;
	}

	/**
	 * merge 'first' and 'second' into 'merged'.
	 * 'first' and 'second' are both supposed to be 'len' in length at most.
	 * 'second' is supposed to be the node after the last node of 'first'.
	 */
	private ListNode merge(ListNode merged, ListNode first, ListNode second, long len) {
		long i = 0, j = 0;
		while (i < len && j < len && second != null) {
			if (first.val < second.val) {
				merged.next = first;
				first = first.next;
				i++;
			} else {
				merged.next = second;
				second = second.next;
				j++;
			}
			merged = merged.next;
		}
		if (i < len) {
			while (i < len && first != null) {
				merged.next = first;
				first = first.next;
				i++;
				merged = merged.next;
			}
			merged.next = second;
		} else {
			while (j < len && second != null) {
				merged.next = second;
				second = second.next;
				j++;
				merged = merged.next;
			}
		}
		return merged;
	}
}

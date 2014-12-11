package merge_k_sorted_lists.v1;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
		PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		for (ListNode head : lists) {
			if (head != null) {
				heap.add(head);
			}
		}
		ListWrapper mergedList = new ListWrapper();
		while (!heap.isEmpty()) {
			ListNode node = heap.poll();
			if (node.next != null) {
				heap.add(node.next);
			}
			mergedList.addLast(node);
		}

		return mergedList.getList();
	}
}


class ListWrapper {

	private ListNode head;
	private ListNode tail;

	public ListWrapper() {
		this.head = new ListNode(0);
		this.tail = this.head;
	}

	public ListNode getList() {
		return this.head.next;
	}

	public void addLast(ListNode node) {
		node.next = null;
		this.tail.next = node;
		this.tail = node;
	}
}

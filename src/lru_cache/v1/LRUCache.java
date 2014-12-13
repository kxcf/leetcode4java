package lru_cache.v1;

import java.util.*;

public class LRUCache {
	private final int capacity;
	private final Map<Integer, DoubleList<Integer, Integer>.ListNode> map;
	private final DoubleList<Integer, Integer> list;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>(capacity);
		this.list = new DoubleList<>();
	}

	public int get(int key) {
		DoubleList<Integer, Integer>.ListNode node = this.map.get(key);
		if (node == null) {
			return -1;
		}
		this.list.remove(node);
		this.list.addFirst(node);
		return node.getValue();
	}

	public void set(int key, int value) {
		DoubleList<Integer, Integer>.ListNode node = this.map.get(key);
		if (node == null) {
			if (this.list.getSize() == this.capacity) {
				node = this.list.removeLast();
				this.map.remove(node.getKey());
			} else {
				node = this.list.new ListNode();
			}
			this.map.put(key, node);
		} else {
			this.list.remove(node);
		}
		this.list.addFirst(node);
		node.setPair(key, value);
	}
}

class DoubleList<K, V> {
	private final ListNode head, tail;
	private int size;

	public DoubleList() {
		this.head = new ListNode();
		this.tail = new ListNode();
		this.head.next = this.tail;
		this.tail.prev = this.head;
		this.size = 0;
	}

	public int getSize() {
		return this.size;
	}

	public void remove(ListNode node) {
		this.size--;
		ListNode prev = node.prev;
		ListNode next = node.next;
		prev.next = next;
		next.prev = prev;
		node.prev = node.next = null;
	}

	public ListNode removeLast() {
		ListNode node = this.tail.prev;
		this.remove(node);
		return node;
	}

	public void addFirst(ListNode node) {
		ListNode next = this.head.next;
		node.next = next;
		node.prev = this.head;
		next.prev = node;
		this.head.next = node;
		this.size++;
	}

	class ListNode {
		private ListNode prev = null;
		private ListNode next = null;
		private K key;
		private V value;

		public V getValue() {
			return this.value;
		}

		public K getKey() {
			return this.key;
		}

		public void setPair(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}

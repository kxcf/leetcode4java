package lru_cache;

import java.util.*;

public class LRUCache2 {
	private int capacity;
	private Map<Integer, Integer> map;

	public LRUCache2(int capacity) {
		this.capacity = capacity;
		this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return this.size() > LRUCache2.this.capacity;
			}
		};
	}

	public int get(int key) {
		Integer value = this.map.get(key);
		if (value == null) {
			return -1;
		}
		return value;
	}

	public void set(int key, int value) {
		this.map.put(key, value);
	}
}

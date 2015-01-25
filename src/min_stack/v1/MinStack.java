package min_stack.v1;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {
	private Deque<Integer> normal = new LinkedList<>();
	private Deque<Integer> min = new LinkedList<>();

	public void push(int x) {
		this.normal.push(x);
		if (this.min.isEmpty() || x <= this.min.peek()) {
			this.min.push(x);
		}
	}

	public void pop() {
		if (this.normal.pop().equals(this.min.peek())) {
			this.min.pop();
		}
	}

	public int top() {
		return this.normal.peek();
	}

	public int getMin() {
		return this.min.peek();
	}
}

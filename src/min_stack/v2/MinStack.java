package min_stack.v2;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {
	private Deque<Long> stack = new LinkedList<>();
	private long min;

	public void push(int x) {
		if (this.stack.isEmpty()) {
			this.min = x;
			this.stack.push(0L);
		} else {
			this.stack.push(x - this.min);
			if (x < this.min) {
				this.min = x;
			}
		}
	}

	public void pop() {
		long tmp = this.stack.pop();
		if (tmp < 0) {
			this.min -= tmp;
		}
	}

	public int top() {
		long tmp = this.stack.peek();
		if (tmp < 0) {
			return (int) this.min;
		}
		return (int) (this.min + tmp);
	}

	public int getMin() {
		return (int) this.min;
	}
}

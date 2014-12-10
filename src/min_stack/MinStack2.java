package min_stack;

class MinStack2 {
	private java.util.Stack<Integer> normal = new java.util.Stack<>();
	private java.util.Stack<Integer> min = new java.util.Stack<>();

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

package majority_element;

public class Solution {
	public int majorityElement(int[] num) {
		int major = 0, count = 0;
		for (int e : num) {
			major = (count == 0) ? e : major;
			count += (e == major) ? 1 : -1;
		}
		return major;
	}
}

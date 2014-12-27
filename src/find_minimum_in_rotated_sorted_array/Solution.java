package find_minimum_in_rotated_sorted_array;

public class Solution {
	public int findMin(int[] num) {
		int left = 0, right = num.length - 1;
		while (left < right) {
			int mid = (left + right) >>> 1;
			//left<=mid<right
			if (num[mid] > num[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return num[left];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findMin(new int[]{4, 5, 6, 7}));
	}
}

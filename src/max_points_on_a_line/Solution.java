package max_points_on_a_line;

import java.util.HashMap;
import java.util.Map;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class Solution {
	public int maxPoints(Point[] points) {
		int maxCount = 0;

		//the total number of rest point is points.length-i
		//if maxCount>=points.length-1, it's no need to continue.
		for (int i = 0; maxCount < points.length - i; i++) {
			int num = 0, overlap = 0;
			Map<Long, Integer> map = new HashMap<>();

			//calcute lines that associatet with points[i]
			for (int j = i + 1; j < points.length; j++) {
				Long slope = this.getSlope(points[i], points[j]);
				if (slope == 0) {
					overlap++;
				} else {
					Integer count = map.get(slope);
					count = count != null ? count + 1 : 1;
					map.put(slope, count);
					num = Math.max(num, count);
				}
			}
			maxCount = Math.max(maxCount, overlap + num + 1);
		}
		return maxCount;
	}

	//this works even if a==b.
	private long getSlope(Point a, Point b) {
		int x = a.x - b.x;
		int y = a.y - b.y;
		if (x == 0 && y == 0) {
			return 0;
		}
		int gcd = this.getGcd(x, y);
		return ((long) x / gcd << 32) | y / gcd;
	}

	//this works even if a==0 and b==0.
	private int getGcd(int a, int b) {
		while (b != 0) {
			int mod = a % b;
			a = b;
			b = mod;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxPoints(new Point[]{new Point(0, 0), new Point(-1, -1), new Point(2, 2)}));
	}
}

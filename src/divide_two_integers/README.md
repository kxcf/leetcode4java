Divide Two Integers
======================

https://oj.leetcode.com/problems/divide-two-integers/

O(log n) time complexity, O(1) space complexity.

divide_two_integers.v1.Solution(460 ms time cost): Simulate the process of binary long division without long type.
This is to find 0 <= b[0..31] <= 1 that satisfies dividend = b0*divisor*2^31 + b1*divisor*2^30 +...+ b31*divisor*2^0
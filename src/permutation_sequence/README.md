Permutation Sequence
======================

https://oj.leetcode.com/problems/permutation-sequence/

O(n^2) time complexity, O(n) space complexity.

372 ms time cost. This problem consists of two parts.
Part one, find the array A[0..n-1] that satisfies:
k-1 = (n-1)!*A[0] + (n-2)!*A[1] + ... + 2!*A[n-3] + 1!*A[n-2] + 0!*A[n-1]
and 0 <= A[i] < n-i (so the last item in the formula above is always 0).
It's obvious that the array A[0..n-1] can be calculated either from 0 to n-1 or reversely. In order to avoid previous calculation of factorial, A[0..n-1] is calculated from end to start here.
Part two, translate A[0..n-1] into final sequence number. A[0..n-1] can be translated from end to start step by step, just like the mathematical solution of Joseph Circle.
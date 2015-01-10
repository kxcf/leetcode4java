Set Matrix Zeros
==========================

https://oj.leetcode.com/problems/set-matrix-zeroes/

O(mn) time complexity, O(1) space complexity.

set_matrix_zeros.v1.Solution(343 ms time cost):	Scans each row from top to bottom with only one pass.

set_matrix_zeros.v2.Solution(362 ms time cost):	A shorter solution, store information about zeros of each row into column 0 and
information about zeros of each column into row 0.

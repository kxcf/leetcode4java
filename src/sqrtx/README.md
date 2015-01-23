Sqrt(x)
==============

https://oj.leetcode.com/problems/sqrtx/

Newton's method without float, 238 ms time cost.

This code is reduced based on the fact that stopping the iteration at the first x*x<=y is OK, if y==0 or y>=2.

To understand this, there are only two cases to be considered:

When y>=6, the initial guessed root, which is half of y, must be greater than the actual root. And the guessed root will keep decreasing during the iteration.

When y is in {0,2,3,4,5}, the initial guessed x is exactly ⌊√y⌋. That is, no iteration at all.

P.S. (dy-1)/(x<<1)+1 is the ceiling of dy/(x<<1), to prevent zero that causes endless loop.
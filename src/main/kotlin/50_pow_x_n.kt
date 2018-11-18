/**
 * https://leetcode.com/problems/powx-n/
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Solution:
 * Simple fast power algorithm
 * O(log N)
 * N == n
 */

fun myPow(x: Double, n: Int): Double {
    if (n == 0) return 1.0
    return if (n % 2 == 0) {
        val part = myPow(x, n / 2)
        part * part
    } else {
        if (n > 0)
            x * myPow(x, n - 1)
        else
            myPow(x, n + 1) / x

    }
}
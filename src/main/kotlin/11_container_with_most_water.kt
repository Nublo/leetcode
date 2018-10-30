/**
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * Solution:
 * 2 Pointers starting from 0, size-1
 * Moving pointer where length is less.
 * O(N)
 * N - length of array
 */

fun maxArea(height: IntArray): Int {
    var result: Int = 0
    var l = 0
    var r = height.size - 1
    while (l < r) {
        val square = Math.min(height[l], height[r]) * (r - l)
        result = Math.max(square, result)

        if (height[l] < height[r])
            l++
        else
            r--
    }
    return result
}
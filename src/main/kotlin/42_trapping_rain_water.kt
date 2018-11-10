import java.util.Stack

/**
 * https://leetcode.com/problems/trapping-rain-water/solution/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Solution:
 * Push in stack items, and if we getting more high value -> take everything from stack with less
 * size and sum to answer
 * O(N)
 * N - length of heights array
 */

fun trap(height: IntArray): Int {
    val stack = Stack<Int>()
    var result = 0
    var position = 0
    while (position < height.size) {
        while (!stack.empty() && height[position] > height[stack.peek()]) {
            val top = stack.pop()
            if (stack.empty()) {
                break
            }
            val distance = position - stack.peek() - 1
            val heightBlock = Math.min(height[position], height[stack.peek()]) - height[top]
            result += distance * heightBlock
        }
        stack.push(position)
        position++
    }
    return result
}
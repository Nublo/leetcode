/**
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * Solution:
 * Sort, than take element and use 2 pointer for remaining part to find answer
 * O(N^2)
 * N - length of heights array
 */
fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    var answer = nums[0] + nums[1] + nums[2]
    for (i in 0..nums.size - 3) {
        var left = i + 1
        var right = nums.size - 1
        while (left < right) {
            val currentAnswer = nums[i] + nums[left] + nums[right]
            if (currentAnswer == target)
                return currentAnswer
            if (Math.abs(answer - target) > Math.abs(currentAnswer - target)) {
                answer = currentAnswer
            }
            if (currentAnswer < target) {
                left++
            } else {
                right--
            }
        }
    }
    return answer
}
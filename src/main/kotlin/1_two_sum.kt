import java.util.HashMap

/**
 * https://leetcode.com/problems/two-sum/description/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Solution:
 * Put elements in HashMap, for fast find do we have specific number.
 * O(N)
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val values = HashMap<Int, Int>()
    for (i in nums.indices) {
        if (values.containsKey(target - nums[i])) {
            val result = IntArray(2)
            result[0] = values[target - nums[i]]!!
            result[1] = i
            return result
        } else {
            values[nums[i]] = i
        }
    }
    return IntArray(2)
}
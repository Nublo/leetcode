import java.util.*

/**
 * https://leetcode.com/problems/3sum/description/
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * The solution set must not contain duplicate triplets.
 *
 * Solution:
 * Move to 2Sum task
 * O(N^2)
 * N - length of heights array
 *
 * Improvments - find better way to remove duplicates
 */
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val unique = HashSet<String>()
    for (i in 0 until nums.size) {
        val sum = nums[i]
        val set = HashSet<Int>()
        for (j in 0 until nums.size) {
            if (i != j) {
                if (set.contains(-nums[j] - sum)) {
                    val answer = (Arrays.asList(sum, nums[j], -nums[j] - sum).sorted().joinToString { it.toString() })
                    if (!unique.contains(answer)) {
                        unique.add(answer)
                        result += Arrays.asList(sum, nums[j], -nums[j] - sum)
                    }
                }
                set += nums[j]
            }
        }
    }
    return result
}
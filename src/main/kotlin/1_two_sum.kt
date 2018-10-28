import java.util.HashMap

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
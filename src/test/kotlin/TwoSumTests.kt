import org.junit.Assert.assertEquals
import org.junit.Test

class TwoSumTests {

    @Test
    fun `Correctly find indexes solution in array`() {
        val nums = IntArray(3)
        nums[0] = 10
        nums[1] = 15
        nums[2] = 11

        val answer = twoSum(nums, 21)
        assertEquals(0, answer[0])
        assertEquals(2, answer[1])
    }

}
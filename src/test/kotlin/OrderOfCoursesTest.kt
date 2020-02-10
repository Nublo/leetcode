import junit.framework.Assert.assertEquals
import org.junit.Test

class OrderOfCoursesTest {

    @Test
    fun `example`() {
        val expected = IntArray(2)
        expected[0] = 1
        expected[1] = 0

        val input = Array(1) { IntArray(2) }
        input[0][0] = 0
        input[0][1] = 1

        val solution = OrderOfCourses().findOrder(2, input)
        for (i in 0 until 2) {
            assertEquals(expected[i], solution[i])
        }
    }

}
import junit.framework.Assert.assertEquals
import org.junit.Test

class StringPermutationsTest {

    @Test
    fun check() {
        val solution = StringPermutations()

        assertEquals(false, solution.checkInclusion("ab", "boa"))
    }

}
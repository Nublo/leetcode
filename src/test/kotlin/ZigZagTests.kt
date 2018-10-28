import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ZigZagTests(
        private val s: String,
        private val numRows: Int,
        private val answer: String
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                    arrayOf("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                    arrayOf("PAYPALISHIRING", 4, "PINALSIGYAHRPI")
            )
        }
    }

    @Test
    fun `correctly find longest palindrome`() {
        Assert.assertEquals(answer, convert(s, numRows))
    }

}
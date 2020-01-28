import junit.framework.Assert.assertEquals
import org.junit.Test

class LadderLengthTest {

    @Test
    fun test() {
        val answer = ladderLength("hit", "cog", listOf("hot","dot","dog","lot","log","cog"))
        assertEquals(5, answer)
    }

}
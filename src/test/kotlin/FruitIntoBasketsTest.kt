import junit.framework.Assert.assertEquals
import org.junit.Test

class FruitIntoBasketsTest {

    @Test
    fun input1() {
        val array = IntArray(4)
        array[0] = 0
        array[1] = 1
        array[2] = 2
        array[3] = 2

        assertEquals(3, FruitIntoBaskets().totalFruit(array))
    }


}
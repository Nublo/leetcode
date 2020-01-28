import CapacityToShipCargo.shipWithinDays
import org.junit.Assert.assertEquals
import org.junit.Test

class CapacityToShipCargoTest {

    @Test
    fun checkWorks() {
        assertEquals(602, shipWithinDays(intArrayOf(147,73,265,305,191,152,192,293,309,292,182,157,381,287,73,162,313,366,346,47), 10))
    }

}
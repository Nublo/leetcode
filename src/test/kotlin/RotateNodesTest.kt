import org.junit.Assert.assertEquals
import org.junit.Test

class RotateNodesTest {

    @Test
    fun testHelperGeneratorWorks() {
        val head = "3->4->5".toListNode()
        assertEquals("3->4->5", head.toString())
    }

    @Test
    fun testSimpleRotateWorks() {
        val head = "3->4->5".toListNode()
        assertEquals("5->4->3", rotateNodes(head).toString())
    }

    @Test
    fun testRotate2GroupWorks() {
        val head = "1->2->3->4->5".toListNode()
        assertEquals("2->1->4->3->5", reverseKGroup(head, 2).toString())
    }

    @Test
    fun testRotate3GroupWorks() {
        val head = "1->2->3->4->5".toListNode()
        assertEquals("3->2->1->4->5", reverseKGroup(head, 3).toString())
    }

}
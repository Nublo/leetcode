import org.junit.Assert.assertEquals
import org.junit.Test

class RotateNodesTest {

    @Test
    fun testHelperGeneratorWorks() {
        val head = "3->4->5".toListNode()
        assertEquals("3->4->5", head.toString())
    }

    @Test
    fun rotateStart2Group() {
        val head = "3->4->5".toListNode()
        assertEquals("4->3->5", rotateStartGroup(head, 2).toString())
    }

    @Test
    fun rotateStart3Group() {
        val head = "3->4->5".toListNode()
        assertEquals("5->4->3", rotateStartGroup(head, 3).toString())
    }

    @Test
    fun rotateRight2() {
        val head = "1->2->3->4->5".toListNode()
        assertEquals("4->5->1->2->3", rotateRight(head, 2).toString())
    }

    @Test
    fun rotateRight4() {
        val head = "0->1->2".toListNode()
        assertEquals("2->0->1", rotateRight(head, 4).toString())
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
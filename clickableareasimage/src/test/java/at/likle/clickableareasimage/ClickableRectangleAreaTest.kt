package at.likle.clickableareasimage

import at.lukle.clickableareasimage.ClickableRectangleArea
import org.junit.Test

class ClickableRectangleAreaTest {

    @Test
    fun check_rectangle_inside_correct() {
        val rectangle = ClickableRectangleArea<Any>(0,0,50,50, Object())

        //verify
        assert(rectangle.isInside(25,25))
        assert(rectangle.isInside(0,0))
        assert(rectangle.isInside(0,50))
        assert(rectangle.isInside(50,0))
        assert(rectangle.isInside(50,50))
        assert(rectangle.isInside(50,25))

        assert(!rectangle.isInside(-1,-1))
        assert(!rectangle.isInside(20,51))
        assert(!rectangle.isInside(-1,25))
        assert(!rectangle.isInside(1000,1000))
    }
}
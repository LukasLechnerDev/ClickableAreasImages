package at.likle.clickableareasimage

import at.lukle.clickableareasimage.ClickablePolyArea
import at.lukle.clickableareasimage.PixelPosition
import org.junit.Test

class ClickablePolyAreaTest {

    @Test
    fun check_poly_inside_correct() {
        val poly = ClickablePolyArea<Any>(Object(),
                PixelPosition(0,0),
                PixelPosition(10,-5),
                PixelPosition(30,10),
                PixelPosition(20,5))

        //verify
        assert(poly.isInside(0,0))
        assert(poly.isInside(10,-5))
        assert(poly.isInside(30,10))
        assert(poly.isInside(20,5))

        assert(poly.isInside(20,3))

        assert(!poly.isInside(-1,-1))
        assert(!poly.isInside(5,-5))
        assert(!poly.isInside(30,5))
        assert(!poly.isInside(20,2))
    }
}
package at.likle.clickableareasimage

import at.lukle.clickableareasimage.ClickableCircleArea
import org.junit.Test

class ClickableCircleAreaTest {

    @Test
    fun check_circle_inside_correct() {
        //before
        val circle = ClickableCircleArea(50, 50, 20, Object())


        //verefy
        assert(circle.isInside(50,50))
        assert(circle.isInside(30,50))
        assert(circle.isInside(70,50))
        assert(circle.isInside(50,70))
        assert(circle.isInside(50,30))
        assert(circle.isInside(40,40))
        assert(circle.isInside(35, 63))

        assert(!circle.isInside(30,30))
        assert(!circle.isInside(30,70))
        assert(!circle.isInside(70,30))
        assert(!circle.isInside(70,70))
        assert(!circle.isInside(35, 64))
    }
}
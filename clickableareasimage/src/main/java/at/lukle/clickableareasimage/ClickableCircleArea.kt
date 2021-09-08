package at.lukle.clickableareasimage

import android.util.Log

public class ClickableCircleArea<T>(
        private val x: Int,
        private val y: Int,
        private val radius : Int,
        item: T
) : AbstractArea<T>(item) {

    override fun isInside(positionX: Int, positionY: Int): Boolean {
        var ret = false
        val dx = x - positionX
        val dy = y - positionY

        // if tap is less than radius distance from the center
        val d = Math.sqrt((dx * dx + dy * dy).toDouble()).toFloat()
        if (d < radius) {
            ret = true
        }
        return ret
    }
}
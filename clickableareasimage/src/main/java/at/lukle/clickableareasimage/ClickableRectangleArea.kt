package at.lukle.clickableareasimage

public class ClickableRectangleArea<T>(
        private val x: Int,
        private val y: Int,
        private val w: Int,
        private val h: Int,
        item: T) : AbstractArea<T>(item) {

    override fun isInside(positionX: Int, positionY: Int): Boolean {
        return isBetween(this.x, this.x + this.w, positionX) && isBetween(this.y, this.y + this.h, positionY)
    }

    private fun isBetween(start: Int, end: Int, actual: Int): Boolean {
        return actual in start..end
    }
}
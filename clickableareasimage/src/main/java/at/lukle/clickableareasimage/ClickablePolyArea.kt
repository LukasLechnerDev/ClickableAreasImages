package at.lukle.clickableareasimage

public class ClickablePolyArea<T>(item : T,
                                  private vararg val points: PixelPosition)
    : AbstractArea<T>(item) {

    override fun isInside(positionX: Int, positionY: Int): Boolean {
        var c = false
        var j = points.size - 1
        for(i in points.indices) {
            val pointI = points[i]
            val pointJ = points[j]
            if (pointI.y > positionY != pointJ.y > positionY
                    && positionX < (pointJ.x - pointI.x) * (positionY - pointI.y)/ (pointJ.y - pointI.y) + pointI.x) {
                c = !c
            }
            j = i
        }
        return c
    }
}
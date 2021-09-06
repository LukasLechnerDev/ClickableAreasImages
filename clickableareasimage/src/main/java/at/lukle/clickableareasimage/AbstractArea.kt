package at.lukle.clickableareasimage

abstract class AbstractArea<T>(var item : T) {

    abstract fun isInside(positionX: Int, positionY: Int): Boolean
}
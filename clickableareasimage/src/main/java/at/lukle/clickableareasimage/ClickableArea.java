package at.lukle.clickableareasimage;

/**
 * Created by Lukas on 10/22/2015.
 */
@Deprecated //use ClickableRectangleArea
public class ClickableArea<T> extends AbstractArea<T> {

    private int x;
    private int y;
    private int w;
    private int h;

    public ClickableArea(int x, int y, int w, int h, T item){
        super(item);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setLabel(T item) {
        super.setItem(item);
    }

    @Override
    public boolean isInside(int positionX, int positionY) {
        return isBetween(this.x, this.x + this.w, positionX) && isBetween(this.y, this.y + this.h, positionY);
    }

    private boolean isBetween(int start, int end, int actual){
        return (start <= actual && actual <= end);
    }
}

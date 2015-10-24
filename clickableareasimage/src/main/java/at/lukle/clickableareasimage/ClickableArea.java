package at.lukle.clickableareasimage;

/**
 * Created by Lukas on 10/22/2015.
 */
public class ClickableArea<T> {

    private int x;
    private int y;
    private int w;
    private int h;

    private T item;

    public ClickableArea(int x, int y, int w, int h, T item){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.item = item;
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

    public T getItem() {
        return item;
    }

    public void setLabel(T item) {
        this.item = item;
    }
}

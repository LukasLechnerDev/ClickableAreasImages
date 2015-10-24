package at.lukle.clickableareasimage;

/**
 * Created by Lukas on 10/22/2015.
 */
public class ImageUtils {
    public static PixelPosition getPixelPosition(float percentX, float percentY, int absW, int absH){
        int absX = Math.round(absW * percentX);
        int absY = Math.round(absH * percentY);
        return new PixelPosition(absX,absY);
    }
}

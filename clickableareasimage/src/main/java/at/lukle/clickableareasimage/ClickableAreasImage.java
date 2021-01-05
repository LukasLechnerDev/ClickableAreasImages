package at.lukle.clickableareasimage;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Lukas on 10/22/2015.
 */
public class ClickableAreasImage implements PhotoViewAttacher.OnPhotoTapListener{

    private PhotoViewAttacher attacher;
    private OnClickableAreaClickedListener listener;

    private List<ClickableArea> clickableAreas;

    private int imageWidthInPx;
    private int imageHeightInPx;

    public ClickableAreasImage(PhotoViewAttacher attacher, OnClickableAreaClickedListener listener){
        this.attacher = attacher;
        init(listener);
    }

    private void init(OnClickableAreaClickedListener listener) {
        this.listener = listener;
        getImageDimensions(attacher.getImageView());
        attacher.setOnPhotoTapListener(this);
    }


    private void getImageDimensions(ImageView imageView){
   
        BitmapDrawable drawable2 = (BitmapDrawable) imageView.getDrawable();
        //After SDK 28 (Android Pie), getBitmap() returns the actual size of the image on the screen
        if (Build.VERSION.SDK_INT > 27) {
            imageWidthInPx = (int) (drawable2.getBitmap().getWidth());
            imageHeightInPx = (int) (drawable2.getBitmap().getHeight());
        } else {
            imageWidthInPx = (int) (drawable2.getBitmap().getWidth() / Resources.getSystem().getDisplayMetrics().density);
            imageHeightInPx = (int) (drawable2.getBitmap().getHeight() / Resources.getSystem().getDisplayMetrics().density);
        }

    }
        

    @Override
    public void onPhotoTap(View view, float x, float y) {
        PixelPosition pixel = ImageUtils.getPixelPosition(x, y, imageWidthInPx, imageHeightInPx);
        List<ClickableArea> clickableAreas = getClickAbleAreas(pixel.getX(), pixel.getY());
        for(ClickableArea ca : clickableAreas){
            listener.onClickableAreaTouched(ca.getItem());
        }
    }

    private List<ClickableArea> getClickAbleAreas(int x, int y){
        List<ClickableArea> clickableAreas= new ArrayList<>();
        for(ClickableArea ca : getClickableAreas()){
            if(isBetween(ca.getX(),(ca.getX()+ca.getW()),x)){
                if(isBetween(ca.getY(),(ca.getY()+ca.getH()),y)){
                    clickableAreas.add(ca);
                }
            }
        }
        return clickableAreas;
    }

    private boolean isBetween(int start, int end, int actual){
        return (start <= actual && actual <= end);
    }

    public void setClickableAreas(List<ClickableArea> clickableAreas) {
        this.clickableAreas = clickableAreas;
    }

    public List<ClickableArea> getClickableAreas() {
        return clickableAreas;
    }
}

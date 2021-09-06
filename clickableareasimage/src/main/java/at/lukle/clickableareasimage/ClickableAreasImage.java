package at.lukle.clickableareasimage;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Lukas on 10/22/2015.
 */
@SuppressWarnings("rawtypes")
public class ClickableAreasImage implements PhotoViewAttacher.OnPhotoTapListener{

    private PhotoViewAttacher attacher;
    private OnClickableAreaClickedListener listener;

    private List<? extends AbstractArea> clickableAreas;

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
        imageWidthInPx = (int) (drawable2.getBitmap().getWidth() / Resources.getSystem().getDisplayMetrics().density);
        imageHeightInPx = (int) (drawable2.getBitmap().getHeight() / Resources.getSystem().getDisplayMetrics().density);
    }
        

    @Override
    public void onPhotoTap(View view, float x, float y) {
        PixelPosition pixel = ImageUtils.getPixelPosition(x, y, imageWidthInPx, imageHeightInPx);
        List<AbstractArea> clickableAreas = getClickAbleAreas(pixel.getX(), pixel.getY());
        for(AbstractArea ca : clickableAreas){
            listener.onClickableAreaTouched(ca.getItem());
        }
    }

    private List<AbstractArea> getClickAbleAreas(int x, int y){
        List<AbstractArea> clickableAreas= new ArrayList<>();
        for(AbstractArea ca : getClickableAreas()){
            if (ca.isInside(x, y)) {
                clickableAreas.add(ca);
            }
        }
        return clickableAreas;
    }

    public void setClickableAreas(List<? extends AbstractArea> clickableAreas) {
        this.clickableAreas = clickableAreas;
    }

    public List<? extends AbstractArea> getClickableAreas() {
        return clickableAreas;
    }
}

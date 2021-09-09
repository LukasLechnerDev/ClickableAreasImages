package at.lukle.clickableareas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import at.lukle.clickableareasimage.AbstractArea;
import at.lukle.clickableareasimage.ClickableArea;
import at.lukle.clickableareasimage.ClickableAreasImage;
import at.lukle.clickableareasimage.ClickableCircleArea;
import at.lukle.clickableareasimage.ClickablePolyArea;
import at.lukle.clickableareasimage.ClickableRectangleArea;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;
import at.lukle.clickableareasimage.PixelPosition;
import uk.co.senab.photoview.PhotoViewAttacher;

@SuppressWarnings("rawtypes")
public class MainActivity extends AppCompatActivity implements OnClickableAreaClickedListener {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.austria_map);

        // Create your image
        ClickableAreasImage clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);

        // Define your clickable area (pixel values: x coordinate, y coordinate, width, height) and assign an object to it
        clickableAreasImage.setClickableAreas(getClickableAreas());
    }

    // Listen for touches on your images:
    @Override
    public void onClickableAreaTouched(Object item) {
        if (item instanceof State) {
            String text = ((State) item).getName();
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    private List<AbstractArea> getClickableAreas() {

        List<AbstractArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableRectangleArea<>(600, 100, 50, 50, new State("Lower Austria")));
        clickableAreas.add(new ClickableRectangleArea<>(440, 125, 50, 50, new State("Upper Austria")));
        clickableAreas.add(new ClickableRectangleArea<>(700, 126, 50, 50, new State("Vienna")));

        clickableAreas.add(new ClickableCircleArea<>(715, 300, 27, new State("Burgenland")));
        clickableAreas.add(new ClickableCircleArea<>(450, 380, 27, new State("Carinthia")));
        clickableAreas.add(new ClickableCircleArea<>(400, 275, 27, new State("Salzburg")));


        clickableAreas.add(new ClickablePolyArea<>(new State("Tyrol"),
                new PixelPosition(170,280),
                new PixelPosition(160,330),
                new PixelPosition(190, 340),
                new PixelPosition(220,330),
                new PixelPosition(220, 280),
                new PixelPosition(195, 270)));
        clickableAreas.add(new ClickablePolyArea<>(new State("Vorarlberg"),
                new PixelPosition(30, 280),
                new PixelPosition(20, 330),
                new PixelPosition(50, 340),
                new PixelPosition(80, 330),
                new PixelPosition(80, 280),
                new PixelPosition(55, 270)));
        clickableAreas.add(new ClickablePolyArea<>(new State("Styria"),
                new PixelPosition(570, 250),
                new PixelPosition(560, 300),
                new PixelPosition(590, 310),
                new PixelPosition(620, 300),
                new PixelPosition(620, 250),
                new PixelPosition(595, 240)));

        return clickableAreas;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

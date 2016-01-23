package at.lukle.clickableareas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import at.lukle.clickableareasimage.ClickableArea;
import at.lukle.clickableareasimage.ClickableAreasImage;
import at.lukle.clickableareasimage.OnClickableAreaClickedListener;
import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity implements OnClickableAreaClickedListener {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add image
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.simpsons);

        // Create your image
        ClickableAreasImage clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);

        // Define your clickable area (pixel values: x coordinate, y coordinate, width, height) and assign an object to it
        List<ClickableArea> clickableAreas = getClickableAreas();
        clickableAreasImage.setClickableAreas(clickableAreas);
    }

    // Listen for touches on your images:
    @Override
    public void onClickableAreaTouched(Object item) {
        if (item instanceof Character) {
            String text = ((Character) item).getFirstName() + " " + ((Character) item).getLastName();
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(150, 500, 225, 225, new Character("Lisa", "Simpson")));
        clickableAreas.add(new ClickableArea(270, 120, 200, 260, new Character("Marge", "Simpson")));
        clickableAreas.add(new ClickableArea(410, 390, 103, 90, new Character("Maggie", "Simpson")));
        clickableAreas.add(new ClickableArea(500, 200, 125, 200, new Character("Homer", "Simpson")));
        clickableAreas.add(new ClickableArea(600, 440, 130, 160, new Character("Bart", "Simpson")));

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

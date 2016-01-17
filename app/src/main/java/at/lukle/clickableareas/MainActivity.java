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
        image.setImageResource(R.drawable.breaking_bad_people_small);

        // Create your image
        ClickableAreasImage clickableAreasImage = new ClickableAreasImage(new PhotoViewAttacher(image), this);

        // Define your clickable area (pixel values: x coordinate, y coordinate, width, height) and assign an object to it
        List<ClickableArea> clickableAreas = getClickableAreas();
        clickableAreasImage.setClickableAreas(clickableAreas);
    }

    // Listen for touches on your images:
    @Override
    public void onClickableAreaTouched(Object item) {
        if (item instanceof Person) {
            String text = ((Person) item).getFirstName() + " " + ((Person) item).getLastName();
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    private List<ClickableArea> getClickableAreas() {

        List<ClickableArea> clickableAreas = new ArrayList<>();

        clickableAreas.add(new ClickableArea(32, 184, 96, 137, new Person("Gustavo", "Fring")));
        clickableAreas.add(new ClickableArea(125, 241, 75, 125, new Person("Saul", "Goodman")));
        clickableAreas.add(new ClickableArea(175, 140, 52, 83, new Person("Mike", "Ehrmantraut")));
        clickableAreas.add(new ClickableArea(230, 185, 47, 72, new Person("Jesse", "Pinkman")));
        clickableAreas.add(new ClickableArea(275, 120, 112, 285, new Person("Walter", "\"Heisenberg\" White")));
        clickableAreas.add(new ClickableArea(445, 225, 68, 117, new Person("Hank", "Schrader")));
        clickableAreas.add(new ClickableArea(495, 214, 52, 62, new Person("Marie", "Schrader")));
        clickableAreas.add(new ClickableArea(535, 150, 86, 180, new Person("Skylar", "White")));
        clickableAreas.add(new ClickableArea(620, 220, 127, 160, new Person("Walter JR", "\"Flynn\" White")));

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
